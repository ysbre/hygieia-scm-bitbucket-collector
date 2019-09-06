package com.capitalone.dashboard.bitbucketapi;

import com.capitalone.dashboard.collector.GitSettings;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class BitbucketApiUrlBuilderTest {

    public static final String HTTPS_HTTPS_SOMERANDOMURL_COM_XYZ_RSA = "https://somerandomurl.com/XYZ/rsa";
    @Mock
    private GitSettings settings;

    @InjectMocks
    private BitbucketApiUrlBuilder testObject;

    @Test
    public void buildReposApiUrl() throws URISyntaxException {
        //J.J. given(settings.getApi()).willReturn("/rest/api/1.0/");
	given(settings.getApi()).willReturn("/api/2.0/repositories/");
        URI actual = testObject.buildReposApiUrl(HTTPS_HTTPS_SOMERANDOMURL_COM_XYZ_RSA);
        assertNotNull(actual);
        //J.J. URI expected = new URIBuilder("https://somerandomurl.com/rest/api/1.0/projects/XYZ/repos/rsa").build();
	URI expected = new URIBuilder("https://somerandomurl.com/api/2.0/repositories/XYZ/rsa").build();
        assertEquals(expected,actual);

    }

    @Test
    public void buildPullRequestApiUrl() throws URISyntaxException {
        //J.J. given(settings.getApi()).willReturn("/rest/api/1.0/");
	given(settings.getApi()).willReturn("/api/2.0/repositories/");
        URI actual = testObject.buildPullRequestApiUrl(HTTPS_HTTPS_SOMERANDOMURL_COM_XYZ_RSA);
        assertNotNull(actual);
        //J.J. URI expected = new URIBuilder("https://somerandomurl.com/rest/api/1.0/projects/XYZ/repos/rsa/pull-requests").build();
	URI expected = new URIBuilder("https://somerandomurl.com/api/2.0/repositories/XYZ/rsa/pullrequests").build();
        assertEquals(expected,actual);
    }

    @Test
    public void buildPullRequestActivitiesApiUrl() throws URISyntaxException {
        //J.J. given(settings.getApi()).willReturn("/rest/api/1.0/");
	given(settings.getApi()).willReturn("/api/2.0/repositories/");
        URI actual = testObject.buildPullRequestActivitiesApiUrl(HTTPS_HTTPS_SOMERANDOMURL_COM_XYZ_RSA,"1111");
        assertNotNull(actual);
        //J.J. URI expected = new URIBuilder("https://somerandomurl.com/rest/api/1.0/projects/XYZ/repos/rsa/pull-requests/1111/activities").build();
	URI expected = new URIBuilder("https://somerandomurl.com/api/2.0/repositories/XYZ/rsa/pullrequests/1111/activity").build();
        assertEquals(expected,actual);
    }
}
