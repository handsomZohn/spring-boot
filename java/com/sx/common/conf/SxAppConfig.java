package com.sx.common.conf;

import com.sx.conf.AppConfig;
import com.sx.conf.ReadXml;
import com.sx.conf.SysConfig;

/**
 * @author windy
 * 若需要在 sx_app_config.xml 中自定义一些配置，
 * <li>比如：&lt;project-config&gt;</li>
 *           &lt;test&gt;test&lt;/test&gt;
 *       &lt;/project-config&gt;
 * 在配置文件中配置后，可入代码中所示获得配置的数据
 */
public class SxAppConfig extends AppConfig {
	
	private static String TEST;

	@Override
	public boolean initSxConfig() {
		// 读取配置文件中临时表缓存数据量
		ReadXml rx = new ReadXml(SysConfig.getSX_APP_CONFIG_PATH());
		try {
			// 读取test节点中的文本值
			TEST = rx.read("project-config", "test");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
    public static String getTEST() {
    	return TEST;
    }

}
