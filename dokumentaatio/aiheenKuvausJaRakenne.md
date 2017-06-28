
**Aihe:** Elämänhallintasovellus. Auttaa käyttäjää hahmottamaan rahan- ja ajankäyttöään.

**Käyttäjät:** Käyttäjä

**Käyttäjän toiminnot:**

* tulojen syöttö
* menojen syöttö

* tehtävien syöttö
* ajankäytön syöttö

* syötettyjen tietojen ja niistä laskettujen arvojen tarkastelu




### Luokkakaavio


![Luokkakaavio](/dokumentaatio/luokkakaavio.png)

### Sekvenssikaaviot
**Käyttäjä avaa budjetinsyöttönäkymän, syöttää tulon onnistuneesti ja katsoo sen yhteenvedosta**
![Sekvenssikaavio1](/dokumentaatio/sekvenssikaavio1.png)

**Käyttäjä syöttää tehtävän ja päivittäisen työajan onnistuneesti**
![Sekvenssikaavio2](/dokumentaatio/sekvenssikaavio2.png)


**Rakennekuvaus:**
Ylin käyttöliittymäluokka alustaa kaikki muut käytettävistä omista luokkaolioista paitsi Tehtävän. Tämä olio antaa näkymille parametreina niiden tarvitsemat logiikkaluokkien oliot, joita näkymissä luetaan, käytetään ja muokataan. Esimerkiksi Ajanhallintanäkymä saa attribuuteikseen parametreinä tehtävälistan ja käyttäjän. Tehtävälista taas muodostuu tehtäväolioista, joidenka parametrit ajanhallintanäkymä käyttäjältä kerää.

Yhteenvetonäkymä käyttää parametreinä attribuuteiksi saaneitaan logiikkaolioita kerätyn datan osoittamiseksi selkeässä valossa. Laskutapahtumat tapahtuvat logiikkaluokissa ja Yhteenvetonäkymä vain kutsuu metodeja.

