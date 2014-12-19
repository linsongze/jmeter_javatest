package com.youboy.jmetertest.demo;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.io.Serializable;
import java.util.Locale;
/**
 * Created with IntelliJ IDEA.
 * User: lsz
 * Date: 2014/12/19 0019
 * Time: 上午 11:23
 * To change this template use File | Settings | File Templates.
 */
public class JavaTestDemo extends AbstractJavaSamplerClient implements Serializable {
    private static final Logger LOG = LoggingManager.getLoggerForClass();
    public JavaTestDemo(){

        LOG.debug(this.whoAmI() + "\tConstruct");
    }
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult results = new SampleResult();
        try {
            results.sampleStart();
            results.setSampleLabel("lsz");
            Thread.sleep(100);
            results.setSuccessful(true);
            results.setResponseCodeOK();
            results.setBodySize(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            results.sampleEnd();
        }
        return results;
    }

    private String whoAmI() {
        StringBuilder sb = new StringBuilder();
        sb.append(Thread.currentThread().toString());
        sb.append("@");
        sb.append(Integer.toHexString(this.hashCode()));
        return sb.toString();
    }
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("SleepTime", String.valueOf(1000L));
        params.addArgument("SleepMask", "0x" + Long.toHexString(1023L).toUpperCase(Locale.ENGLISH));
        return params;
    }
}
