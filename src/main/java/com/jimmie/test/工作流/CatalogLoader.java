package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 *
 * @author jimmie
 * @create 2018-11-27 下午12:14
 */

/**
 * @author jimmie
 * @create 2018-11-27 下午12:14
 */

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.CatalogFactory;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;

public class CatalogLoader {

    private ConfigParser parser;

    private Catalog catalog;

    public CatalogLoader() {
        parser = new ConfigParser();
    }

    public Catalog getCatalog(String url, String name) throws Exception {
        if (catalog == null) {
            parser.parse(CatalogLoader.class.getResource(url));
        }
        CatalogFactory instance = CatalogFactoryBase.getInstance();
        if (name == "" || name == null)
            catalog = instance.getCatalog();
        else
            catalog = instance.getCatalog(name);
        return catalog;
    }

}
