package PayRetailers.driver;

import io.restassured.RestAssured;

public class HttpResponseCode {
	
	public static int httpResponseCodeViaGet(String url) {
		RestAssured.useRelaxedHTTPSValidation();
		int status=RestAssured.get(url).statusCode();
		return status;
	}

	public static int httpResponseCodeViaPost(String url) {
		int status= RestAssured.post(url).statusCode();

		return status;
	}

}
