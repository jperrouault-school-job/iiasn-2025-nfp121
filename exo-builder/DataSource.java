public class DataSource {
    private String hostname;
    private int port;
    private boolean secure;
    private String username;
    private String password;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataSource(String hostname, int port, boolean secure, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.secure = secure;
        this.username = username;
        this.password = password;
    }

    public DataSource() { }

    public static DataSourceBuilderV1 builderV1() {
        return new DataSourceBuilderV1();
    }
    
    public static DataSourceBuilderV2 builderV2() {
        return new DataSourceBuilderV2();
    }

    // Avec instance existante
    public static class DataSourceBuilderV1 {
        private DataSource instance = new DataSource();

        public DataSource build() {
            return this.instance;
        }

        public DataSourceBuilderV1 hostname(String hostname) {
            this.instance.hostname = hostname;

            return this;
        }

        public DataSourceBuilderV1 port(int port) {
            this.instance.port = port;

            return this;
        }
        
        public DataSourceBuilderV1 secure(boolean secure) {
            this.instance.secure = secure;

            return this;
        }

        public DataSourceBuilderV1 username(String username) {
            this.instance.username = username;

            return this;
        }

        public DataSourceBuilderV1 password(String password) {
            this.instance.password = password;

            return this;
        }
    }

    // Sans instance préalablement existante
    public static class DataSourceBuilderV2 {
        private String hostname;
        private int port;
        private boolean secure;
        private String username;
        private String password;

        public DataSource build() {
            return new DataSource(hostname, port, secure, username, password);
        }

        public DataSourceBuilderV2 hostname(String hostname) {
            this.hostname = hostname;

            return this;
        }

        public DataSourceBuilderV2 port(int port) {
            this.port = port;

            return this;
        }
        
        public DataSourceBuilderV2 secure(boolean secure) {
            this.secure = secure;

            return this;
        }

        public DataSourceBuilderV2 username(String username) {
            this.username = username;

            return this;
        }

        public DataSourceBuilderV2 password(String password) {
            this.password = password;

            return this;
        }
    }
}
