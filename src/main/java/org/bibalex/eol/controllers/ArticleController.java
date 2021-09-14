package org.bibalex.eol.controllers;


import org.bibalex.eol.collections.Article;
import org.bibalex.eol.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleServ;

    //TODO: Versioning , pagination
    @RequestMapping(value="/getByResource/{resourceId}", method = RequestMethod.GET)
    public List<Article> getByResourceId(@PathVariable("resourceId")int resourceId, @RequestParam (defaultValue = "0") int page)
    {

        return articleServ.getByResourceId(resourceId, page);
    }

    @RequestMapping(value="/getByResourceAndPk/{resourceId}/{articleId}", method = RequestMethod.GET)
    public Article getByResourceAndPk(@PathVariable("resourceId") int resourceId, @PathVariable("articleId") String articleId)
    {
           return articleServ.getByResourceAndPk(resourceId, articleId);
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insertArticles(@RequestBody List<Article> articles)
    {
          articleServ.insertArticles(articles);
    }

    @RequestMapping(value="/count", method = RequestMethod.GET)
    public long countArticles()
    {
       return articleServ.countArticles();
    }

    //todo: reharvest
    //Updating instances by resource_id and resource_pk, setting a variable set of fields/values
}
