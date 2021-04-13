# Yhteystietomanageri

**Huom:** Vaatimusmäärittelyssä oli määritelty, että sisäänkirjautumiseen tarvitaan salasana, mutta päätin että se ei ollut lopuksi hyödyllinen. Tästä syystä sisäänkirjautuminen tulee vaatimaan vain käyttäjänimen.

Yhteystietomanagerin avulla pystyy pitämään kirjaa omista yhteystiedoistaan (Ihmisen nimi, puhelinnumero ja sähköpostiosoite).

Sovellus on suunniteltu käyttäen Java 11:ta.



## Ohjelman käyttö

### Käynnistäminen

Ohjelman voi käynnistää komennolla `./gradlew run`



### Testaus

Testit voi suorittaa komennolla `./gradlew test`



### Jacoco

Jacoco testikattavuuden voi luoda komennolla `./gradlew jacocoTestReport`



## Ohjelman konfiguraatio

Data tallennetaan oletuksena käyttäjän kotihakemistoon "Contactmanager" kansion alle. Tämän voi muuttaa `contactmanager-datadir` ympäristömuuttujalla.