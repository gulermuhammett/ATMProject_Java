import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// Muhammet Güler : İBAN TR12 3456 7890 1234 5678 9012 3456
		// Ahmet Güler    : İBAN TR12 3456 7890 1234 5678 9012 2109
		
		/*
		 * muhammet kullanıcı adı ve şifresi: muhammet / 1234
		 * ahmet kullanıcı adı ve şifresi 	: ahmet	   / 4321 
		 * Bakiye görüntülemek için 		--> 1
		 * Para Çekmek için 		        --> 2
		 * Farklı hesaba para yatırmak için --> 3
		 * uygulamadan çıkmak için 			--> q tuşuna basınız
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		String IbanMG="TR12 3456 7890 1234 5678 9012 3456";
		String ibanAG="TR12 3456 7890 1234 5678 9012 2109";
		
		int bakiyeMG=30000;
		int bakiyeAG=30000;
		
		String kullaniciAdiMG="muhammet";
		String kullaniciAdiAG="ahmet";
		
		String kullaniciSifreMG="1234";
		String kullaniciSifreAG="4321";
		
		String iban=null;
		Integer bakiye=null;

		System.out.println("ATM'ye Hoşgeldiniz");
		System.out.print("Kullanıcı Adı Giriniz: ");
		String girilenKullaniciAdi = scanner.nextLine();
		System.out.print("Şifre giriniz: ");
		String girilenSifre = scanner.nextLine();
		
		if (girilenKullaniciAdi.equals(kullaniciAdiMG) && girilenSifre.equals(kullaniciSifreMG)) {
			iban=IbanMG;
			bakiye=bakiyeMG;
			System.out.println("Muhammet hesabına giriş yapıldı");
		} else if (girilenKullaniciAdi.equals(kullaniciAdiAG) && girilenSifre.equals(kullaniciSifreAG)) {
			iban=ibanAG;
			bakiye=bakiyeAG;
			System.out.println("Ahmet hesabına giriş yapıldı");
		} else {
			System.out.println("Kullanıcı Adı veya Parola Hatalı Lütfen Tekrar Giriş Yapınız!!!");
		}
		if (iban!=null && bakiye!=null) {
			System.out.println("Bakiye görüntülemek için 		 --> 1");
			System.out.println("Para Çekmek için 		         --> 2");
			System.out.println("Farklı hesaba para yatırmak için --> 3");
			System.out.println("Uygulamadan çıkmak için		     --> q");
			System.out.print("Seçiminiz: ");
			String secim = scanner.nextLine();
			
			
			switch (secim) {
			case "1":
				System.out.println("Bakiyeniz: "+ bakiye);
				break;
			case "2":
			    System.out.print("Lütfen çekilecek para miktarını giriniz: ");
			    int cekilen = scanner.nextInt();
			    if (bakiye < cekilen) {
			        System.out.println("Bakiyeniz yetersiz. Mevcut Bakiyeniz: " + bakiye);
			    } else {
			    	bakiye -= cekilen;
			    }
			    System.out.println("Mevcut Bakiyeniz: " + bakiye);
			    break;
			case "3":
				System.out.print("Lütfen gönderilecek IBAN'ı giriniz: ");
				String yatirilacakIban=scanner.nextLine();
				
				if (yatirilacakIban.length()!=26) {
					System.out.println("Hatalı IBAN Adresi!!!\nTekrar Deneyiniz");
				} else if(yatirilacakIban==ibanAG) {
					System.out.print(kullaniciAdiAG+" isimli kişiye göndermek istediğiniz miktarı giriniz: ");
					int gonderilen=scanner.nextInt();
					bakiye-=gonderilen;
					bakiyeAG+=gonderilen;
				}else {
					System.out.println("Lütfen göndermek istediğiniz miktarı giriniz: ");
					int gonderilen=scanner.nextInt();
					bakiye-=gonderilen;
				}
				
				System.out.println("Mevcut Bakiyeniz: "+ bakiyeMG);
				break;
			case "q":
				System.out.print("Çıkış işleminiz başarıyla gerçekleşti!!! ");
				break;

			default:
				System.out.println("Lütfen sadece belirtilen seçenekleri tuşlayınız");
				break;
			}
		} else {

		}
		
	}

}
