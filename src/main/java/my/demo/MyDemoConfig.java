package my.demo;


import java.io.File;

import org.elfinder.servlets.config.AbstractConnectorConfig;
import org.elfinder.servlets.fs.DiskFsImpl;
import org.elfinder.servlets.fs.IFsImpl;

/**
 * @author Antoine Walter (www.anw.fr)
 * @date 29 aug. 2011
 * @version $Id$
 * @license BSD
 */

/**
 * Sample of custom connector configuration.
 */
public class MyDemoConfig extends AbstractConnectorConfig {

	/**
	 * Filesystem.
	 */
	private DiskFsImpl fsImpl;

	public MyDemoConfig() {
		fsImpl = new DiskFsImpl();
	}

	@Override
	public IFsImpl getFs() {
		return fsImpl;
	}

	@Override
	public String getRoot() {
		return MyDemoServlet.HOME_SHARED_DOCS;
	}

	@Override
	public String getRootUrl() {
		return MyDemoServlet.REALOBJECTURL;
	}
	
	@Override
	public String getFileUrl(File path) {
		return getRootUrl() + "/" + getRelativePath(path);
	}

	@Override
	public String rootAliasOrBaseName() {
		return MyDemoServlet.SHARED_DOCS;
	}
	
	@Override
	public String getThumbnailUrl(File path) {
		return MyDemoServlet.THUMBNAIL + getRelativePath(path);
	}
	
	@Override
	public boolean hasThumbnail(File path) {
		String mimeType = getMime(path);
		return mimeType.contains("image");
	}
}
