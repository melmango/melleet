package cn.melman.melleet;

public class Q071 {

    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            if (str.length() == 0) {
                continue;
            }
            if (".".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                int lastSlashIndex = sb.lastIndexOf("/");
                if (lastSlashIndex >= 0) {
                    sb.delete(lastSlashIndex, sb.length());
                }
            } else {
                sb.append('/');
                sb.append(str);
            }
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();

    }


    public String simplifyPath1(String path) {
        StringBuilder sb = new StringBuilder();
        boolean lastPoint = false;
        boolean lastSlash = false;
        for (int i = 0, len = path.length(); i < len; i++) {
            char c = path.charAt(i);
            switch (c) {
                case '/': {
                    lastPoint = false;
                    if (lastSlash) {
                        continue;
                    }
                    lastSlash = true;
                }
                break;
                case '.': {
                    if (lastSlash) {
                        if (lastPoint) {
                            int lastSlashIndex = sb.lastIndexOf("/");
                            if (lastSlashIndex >= 0) {
                                sb.delete(lastSlashIndex, sb.length());
                            }
                            lastPoint = false;
                            lastSlash = false;
                        } else {
                            lastPoint = true;
                        }
                    } else {
                        sb.append(c);
                    }
                }
                break;
                default: {
                    if (lastSlash) {
                        sb.append('/');
                    }
                    lastSlash = false;
                    lastPoint = false;
                    sb.append(c);
                }
                break;
            }
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }

    public static final void main(String[] args) {
//        System.out.println(new Q071().simplifyPath("/..."));
        System.out.println(new Q071().simplifyPath("/a//b////c/d//././/.."));

    }


}
