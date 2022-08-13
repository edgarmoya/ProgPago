package custom_swing.Menu;

import javax.swing.Icon;

/**
 *
 * @author Edgar Moya
 */
public class ModelMenu {
    
    private Icon icon;
    private String menuName;
    private String subMenu[];
    
    public ModelMenu() {
    }
    
    public ModelMenu(Icon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }
}
