package com.telekurye.yedek;

public class CopyOfConstHelper {

	public static class BuildingType {

		public static class Ev {
			public static int		Id			= 1;
			public static String	Description	= "Ev";
		}

		public static class Apartman {
			public static int		Id			= 2;
			public static String	Description	= "Apartman";
		}

	}

	public static class DistributionMissionFeedbackRelation {

		public static class Kendisi {
			public static int		Id			= 1;
			public static String	Description	= "KENDÝSÝ";
		}

		public static class Sekreter {
			public static int		Id			= 2;
			public static String	Description	= "SEKRETER";
		}

		public static class FirmaCalisani {
			public static int		Id			= 3;
			public static String	Description	= "FÝRMA ÇALIÞANI";
		}

		public static class FirmaYetkilisi {
			public static int		Id			= 5;
			public static String	Description	= "FÝRMA YETKÝLÝSÝ";
		}

		public static class FirmaGuvenlikElemani {
			public static int		Id			= 7;
			public static String	Description	= "FÝRMA GÜVENLÝK ELEMANI";
		}

		public static class Muhaberat {
			public static int		Id			= 8;
			public static String	Description	= "MUHABERAT";
		}

		public static class Danisma {
			public static int		Id			= 10;
			public static String	Description	= "DANIÞMA";
		}

		public static class BirimMuduru {
			public static int		Id			= 11;
			public static String	Description	= "BÝRÝM MÜDÜRÜ";
		}

		public static class MuhasebeSorumlusu {
			public static int		Id			= 12;
			public static String	Description	= "MUHASEBE SORUMLUSU";
		}

		public static class BankaSubeGorevlisi {
			public static int		Id			= 13;
			public static String	Description	= "BANKA ÞUBE GÖREVLÝSÝ";
		}

		public static class HanedekiSahis {
			public static int		Id			= 14;
			public static String	Description	= "HANEDEKÝ ÞAHIS";
		}

		public static class BirinciDerecedeYakin {
			public static int		Id			= 15;
			public static String	Description	= "1. DERECE YAKIN";
		}

		public static class Komsu {
			public static int		Id			= 16;
			public static String	Description	= "KOMÞU";
		}

	}

	public static class EndPointStatus {

		public static class TeslimEdildi {
			public static int		Id			= 1;
			public static String	Description	= "TESLÝM EDÝLDÝ";
		}

		public static class EvdeYokHaberKagidiBirakildi {
			public static int		Id			= 9;
			public static String	Description	= "EVDE YOK - HABER KAÐIDI BIRAKILDI";
		}

		public static class IadeAdresHataliEksikYetersiz {
			public static int		Id			= 10;
			public static String	Description	= "ÝADE: ADRES HATALI-EKSÝK-YETERSÝZ";
		}

		public static class IadeAdresteTaninmiyor {
			public static int		Id			= 11;
			public static String	Description	= "ÝADE: ADRESTE TANINMIYOR";
		}

		public static class IadeTasinmis {
			public static int		Id			= 12;
			public static String	Description	= "ÝADE: TAÞINMIÞ";
		}

		public static class IadeDagitimaIzinVerilmiyor {
			public static int		Id			= 13;
			public static String	Description	= "ÝADE: DAÐITIMA ÝZÝN VERÝLMÝYOR";
		}

		public static class IadeKabulEdilmiyor {
			public static int		Id			= 17;
			public static String	Description	= "ÝADE: KABUL EDÝLMÝYOR";
		}

		public static class IadeGecerliKimlikGostermedi {
			public static int		Id			= 18;
			public static String	Description	= "ÝADE: GEÇERLÝ KÝMLÝK GÖSTERMEDÝ";
		}

		public static class IadeVefatEtmis {
			public static int		Id			= 20;
			public static String	Description	= "ÝADE: VEFAT ETMÝÞ";
		}

		public static class IadeTayiniCikmisIstenAyrilmis {
			public static int		Id			= 21;
			public static String	Description	= "ÝADE: TAYÝNÝ ÇIKMIÞ-ÝÞTEN AYRILMIÞ";
		}

		public static class KuryeDevir {
			public static int		Id			= 26;
			public static String	Description	= "KURYE DEVÝR";
		}

	}

	public static class IdentityType {

		public static class NufusCuzdani {
			public static int		Id			= 1;
			public static String	Description	= "NÜFUS CÜZDANI";
		}

		public static class Ehliyet {
			public static int		Id			= 2;
			public static String	Description	= "EHLÝYET";
		}

		public static class Pasaport {
			public static int		Id			= 3;
			public static String	Description	= "PASAPORT";
		}

	}

	public static class MobileMessagingStatusType {

		public static class Okunmadi {
			public static int		Id			= 1;
			public static String	Description	= "OKUNMADI";
		}

		public static class Okundu {
			public static int		Id			= 2;
			public static String	Description	= "OKUNDU";
		}

		public static class Silindi {
			public static int		Id			= 4;
			public static String	Description	= "SÝLÝNDÝ";
		}

	}

	public static class MobileMessagingType {

		public static class Acil {
			public static int		Id			= 2;
			public static String	Description	= "ACÝL";
		}

		public static class Onemli {
			public static int		Id			= 4;
			public static String	Description	= "ÖNEMLÝ";
		}

		public static class Bilgi {
			public static int		Id			= 5;
			public static String	Description	= "BÝLGÝ";
		}

	}

	public static class PickUpFeedBackStatus {

		public static class AlimBasarili {
			public static int		Id			= 1;
			public static String	Description	= "ALIM BAÞARILI";
		}

		public static class AlimBasarisiz {
			public static int		Id			= 2;
			public static String	Description	= "ALIM BAÞARISIZ";
		}

		public static class AlimYapilamayacak {
			public static int		Id			= 4;
			public static String	Description	= "ALIM YAPILAMAYACAK";
		}

	}

}

// String startDateString = "2011-08-26 00:00:00";
// DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// Date startDate = null;
// try {
// startDate = df.parse(startDateString);
// } catch (ParseException e) {
// e.printStackTrace();
// }
// ModifiedDate = startDate;
// CreateDate = startDate;
// UserId_Create = 1;
// UserId_Modify = 1;
