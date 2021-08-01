# Info

Demo project for Spring Actuator Micrometer

https://www.callicoder.com/spring-boot-actuator/  
https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/

# Test

Using https://httpie.io/

```
http localhost:8080/

http localhost:8080/actuator/health

# Metrics and Shutdown Endpoints are protected, see SecurityConfigActuator.class
http localhost:8080/actuator/metrics # 401 Unauthorized
http -a actuator_user:actuator_pass localhost:8080/actuator/metrics

http localhost:8080/actuator/loggers
http localhost:8080/actuator/loggers/bcp
http localhost:8080/ # See log output
echo '{"configuredLevel": "DEBUG"}' | http POST localhost:8080/actuator/loggers/bcp

http -a actuator_user:actuator_pass POST localhost:8080/actuator/shutdown
```

## Prometheus and Grafana

```
docker pull prom/prometheus
docker run -d --name=prometheus -p 9090:9090 -v <PATH_TO_prometheus.yml_FILE>:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml

docker run -d --name=grafana -p 3000:3000 grafana/grafana

```