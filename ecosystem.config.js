module.exports = {
  apps: [
    {
      name: "api-gateway",
      script: "java",
      args: "-jar api-gateway.jar",
      cwd: "/opt/pulsefit/api-gateway",
      env: {
        SERVER_PORT: "8080",
        CONFIG_SERVER_URL: "http://localhost:8888",
        EUREKA_SERVER_URL: "http://localhost:8761/eureka"
      },
      autorestart: true,
      max_restarts: 10,
      min_uptime: "10s",
      restart_delay: 3000,
      out_file: "/var/log/pm2/api-gateway-out.log",
      error_file: "/var/log/pm2/api-gateway-error.log",
      log_date_format: "YYYY-MM-DD HH:mm:ss"
    }
  ]
};
