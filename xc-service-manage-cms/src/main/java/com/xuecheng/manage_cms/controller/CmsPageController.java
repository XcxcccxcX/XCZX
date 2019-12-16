package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/12/12.
 * @author xcx
 */
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page,@PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        //定义返回对象中的参数对象 泛型为CmsPage
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
        List<CmsPage> lists = new ArrayList<>();
        //创建CmsPage对象
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("test");
        lists.add(cmsPage);
        cmsPageQueryResult.setList(lists);
        cmsPageQueryResult.setTotal(1);
        //定义返回信息对象
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
        return queryResponseResult;
    }
}
