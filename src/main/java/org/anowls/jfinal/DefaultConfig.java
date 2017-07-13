package org.anowls.jfinal;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import org.anowls.jfinal.controller.IndexController;
import org.anowls.jfinal.model._MappingKit;

/**
 * Created by Administrator on 2016/3/22.
 */
public class DefaultConfig extends JFinalConfig{

    @Override
    public void configConstant(Constants me) {
        PropKit.use("a_little_config.txt");
        me.setViewType(ViewType.FREE_MARKER);
    }

    @Override
    public void configRoute(Routes me) {
        me.setBaseViewPath("/WEB-INF/views");
        me.add("/", IndexController.class);
    }

    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        C3p0Plugin C3p0Plugin = createC3p0Plugin();
        me.add(C3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
//        arp.setDialect(new AnsiSqlDialect());
        me.add(arp);

        // 所有配置在 MappingKit 中搞定
        _MappingKit.mapping(arp);
    }

    public static C3p0Plugin createC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("base"));
    }
}
