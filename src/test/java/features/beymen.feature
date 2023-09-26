@beymen

  Feature: Beymen Mobil Uygulamasi
    Scenario: Beymen mobilden sepete urun ekleme, sayisini arttirma ve kontrol etme otomasyonu

      When Konum etkinlestirilir.
      Then Ana sayfada bulunan banner alaninin gorunur oldugu dogrulanır.
      Then Kategorilerin gorunur oldugu dogrulanir ve tıklanır.
      When Kadin kategorisi secilir.
      Then Kadin kategorisinin alt kategorilerinin gorunur oldugu dogrulanır.
      When Tum Kadin secenegi secilir.
      Then Sepete eklenebilecek urunlerin siralandigi gorulur.
      When Herhangi bir urun secilir
      And Beden secimi yapilarak sepete eklenir.
      Then “Urun sepetinize eklendi” bilgisinin gorunur oldugu dogrulanır.
      When Sepete Git secenegi secilir.
      And Urun adedi 1 adet arttirilir.
      Then Fiyat bilgisinin aynı oranda arttigi dogrulanir.