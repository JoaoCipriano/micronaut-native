FROM cgr.dev/chainguard/wolfi-base:latest
COPY target/app /app/app
COPY target/lib* /app/
RUN chmod +x /app/app
EXPOSE 8080
ENTRYPOINT ["/app/app"]