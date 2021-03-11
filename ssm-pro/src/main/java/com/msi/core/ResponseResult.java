package com.msi.core;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msi.core.bean.PageVO;
import com.msi.core.bean.ResultBean;
import com.msi.core.interfaces.FunctionExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description TODO
 */
@Component
public class ResponseResult<T, E> {
    private static final Logger LOG = LoggerFactory.getLogger(ResponseResult.class);

    public ResultBean result(Page page, FunctionExecutor<T> functionExecutor) {
        ResultBean resultBean = new ResultBean();
        try {
            T t = functionExecutor.execute();
            if (t instanceof List || t == null) {
                PageVO<E> pageVO;
                if (page == null) {
                    if (t != null) {
                        pageVO = new PageVO<>((List<E>) t, (long) ((List) t).size(), (long) ((List) t).size(), 1L);
                    } else {
                        pageVO = new PageVO<>(null, 0L, 0L, 1L);
                    }
                } else {
                    pageVO = new PageVO<>((List<E>) t, page.getSize(), page.getTotal(), page.getCurrent());
                }
                resultBean.setData(pageVO);
            } else {
                resultBean.setData(t);
            }
            resultBean.setFlag(true);
        } catch (Exception e) {
            LOG.error(LocalDateTime.now() + "====》》" + e.toString());
            resultBean.setCode(500).setMsg(e.toString()).setFlag(false);
        } finally {
            return resultBean;
        }

    }
}
