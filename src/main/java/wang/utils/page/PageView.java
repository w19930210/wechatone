package wang.utils.page;

import com.github.pagehelper.*;

/**
 * 分页管理
 */
public class PageView extends PageHelper {

    public PageView() {
    }

    public static Page startDataPage(int pageNum, int pageSize) {
        return startDataPage(pageNum, pageSize, true);
    }

    public static Page startDataPage(int pageNum, int pageSize, boolean count) {
        com.github.pagehelper.Page page = new com.github.pagehelper.Page(pageNum, pageSize, count);
        setLocalPage(page);
        Page myPage = new Page(page);
        return myPage;
    }

}
