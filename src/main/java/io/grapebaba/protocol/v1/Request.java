package io.grapebaba.protocol.v1;

import com.google.common.base.MoreObjects;
import io.grapebaba.protocol.Body;

import java.util.Objects;

public class Request implements Body {
    private Integer opaque;

    private Integer timeout;

    private String beanName;

    private String methodName;

    private Object[] arguments;

    public Object[] getArguments() {
        return arguments;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public Integer getOpaque() {
        return opaque;
    }

    public Integer getTimeout() {
        return timeout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(opaque, request.opaque) &&
                Objects.equals(timeout, request.timeout) &&
                Objects.equals(beanName, request.beanName) &&
                Objects.equals(methodName, request.methodName) &&
                Objects.equals(arguments, request.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opaque, timeout, beanName, methodName, arguments);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arguments", arguments)
                .add("opaque", opaque)
                .add("timeout", timeout)
                .add("beanName", beanName)
                .add("methodName", methodName)
                .toString();
    }

    public static class RequestBuilder {
        private Request request;

        private RequestBuilder() {
            request = new Request();
        }

        public RequestBuilder withOpaque(Integer opaque) {
            request.opaque = opaque;
            return this;
        }

        public RequestBuilder withTimeout(Integer timeout) {
            request.timeout = timeout;
            return this;
        }

        public RequestBuilder withBeanName(String beanName) {
            request.beanName = beanName;
            return this;
        }

        public RequestBuilder withMethodName(String methodName) {
            request.methodName = methodName;
            return this;
        }

        public RequestBuilder withArguments(Object[] arguments) {
            request.arguments = arguments;
            return this;
        }

        public static RequestBuilder request() {
            return new RequestBuilder();
        }

        public Request build() {
            return request;
        }
    }
}
