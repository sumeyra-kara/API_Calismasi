package test.Informationen;

public class Pojo {
    /*
    - Response'in temel bilgilerini nasil test ediyoruz? assert.then().assertThat().

    - Response'in body'sini test etmek icin ?
            Matchers class'ina ihtiyac vardir
            assert. then . assertThat(). body()

    - Karmasik json objeleri varsa response'dan sonra then.assertThat ile body'i test edeceksek JsonPath ile yapariz

    - respose'i testNg ya da Junit ile test etmek istersek response json Path'E cevrilir
      hazirladigimiz expexteddata'lar jsonObject türünde oluyor.
        karmasik jsonpath test ederken -----> aralarina nokta koyarak kolayca
        karmasik jsonObject test ederken ----> katmanli her bir katmana ayri method ile giriyoruz getJsonObject().get(...)

    - expexted data formati (jsonObject, map, pojo) olarak hazirladik

    - expected data map olarak hazirlandiysa test etmek icin ne yapmali? (map zor ve ugrastiricidir)
          donen response map'e donusturulur. casting vs yapilir.

    - Pojo'da expected data pojo olarak hazirlandigi icin donen response'i da pojo obje'ye donustururuz

    - data typle'in ayni olmasina dikkat edilmeli

    - pojo'da eger katmanli bir yapi varsa en icteki pojo'dan olusturmaya baslamak gerekir









     */
}
