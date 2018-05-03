package cn.zcj.examOnline;

import org.beetl.ext.nutz.BeetlViewMaker;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@SetupBy(value=MainSetup.class)
@Modules(scanPackage=true)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/","*anno", "cn.zcj.examOnline","*tx"})
@Views({BeetlViewMaker.class})



public class MainModule {
	

}
