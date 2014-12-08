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
			public static String	Description	= "KEND�S�";
		}

		public static class Sekreter {
			public static int		Id			= 2;
			public static String	Description	= "SEKRETER";
		}

		public static class FirmaCalisani {
			public static int		Id			= 3;
			public static String	Description	= "F�RMA �ALI�ANI";
		}

		public static class FirmaYetkilisi {
			public static int		Id			= 5;
			public static String	Description	= "F�RMA YETK�L�S�";
		}

		public static class FirmaGuvenlikElemani {
			public static int		Id			= 7;
			public static String	Description	= "F�RMA G�VENL�K ELEMANI";
		}

		public static class Muhaberat {
			public static int		Id			= 8;
			public static String	Description	= "MUHABERAT";
		}

		public static class Danisma {
			public static int		Id			= 10;
			public static String	Description	= "DANI�MA";
		}

		public static class BirimMuduru {
			public static int		Id			= 11;
			public static String	Description	= "B�R�M M�D�R�";
		}

		public static class MuhasebeSorumlusu {
			public static int		Id			= 12;
			public static String	Description	= "MUHASEBE SORUMLUSU";
		}

		public static class BankaSubeGorevlisi {
			public static int		Id			= 13;
			public static String	Description	= "BANKA �UBE G�REVL�S�";
		}

		public static class HanedekiSahis {
			public static int		Id			= 14;
			public static String	Description	= "HANEDEK� �AHIS";
		}

		public static class BirinciDerecedeYakin {
			public static int		Id			= 15;
			public static String	Description	= "1. DERECE YAKIN";
		}

		public static class Komsu {
			public static int		Id			= 16;
			public static String	Description	= "KOM�U";
		}

	}

	public static class EndPointStatus {

		public static class TeslimEdildi {
			public static int		Id			= 1;
			public static String	Description	= "TESL�M ED�LD�";
		}

		public static class EvdeYokHaberKagidiBirakildi {
			public static int		Id			= 9;
			public static String	Description	= "EVDE YOK - HABER KA�IDI BIRAKILDI";
		}

		public static class IadeAdresHataliEksikYetersiz {
			public static int		Id			= 10;
			public static String	Description	= "�ADE: ADRES HATALI-EKS�K-YETERS�Z";
		}

		public static class IadeAdresteTaninmiyor {
			public static int		Id			= 11;
			public static String	Description	= "�ADE: ADRESTE TANINMIYOR";
		}

		public static class IadeTasinmis {
			public static int		Id			= 12;
			public static String	Description	= "�ADE: TA�INMI�";
		}

		public static class IadeDagitimaIzinVerilmiyor {
			public static int		Id			= 13;
			public static String	Description	= "�ADE: DA�ITIMA �Z�N VER�LM�YOR";
		}

		public static class IadeKabulEdilmiyor {
			public static int		Id			= 17;
			public static String	Description	= "�ADE: KABUL ED�LM�YOR";
		}

		public static class IadeGecerliKimlikGostermedi {
			public static int		Id			= 18;
			public static String	Description	= "�ADE: GE�ERL� K�ML�K G�STERMED�";
		}

		public static class IadeVefatEtmis {
			public static int		Id			= 20;
			public static String	Description	= "�ADE: VEFAT ETM��";
		}

		public static class IadeTayiniCikmisIstenAyrilmis {
			public static int		Id			= 21;
			public static String	Description	= "�ADE: TAY�N� �IKMI�-��TEN AYRILMI�";
		}

		public static class KuryeDevir {
			public static int		Id			= 26;
			public static String	Description	= "KURYE DEV�R";
		}

	}

	public static class IdentityType {

		public static class NufusCuzdani {
			public static int		Id			= 1;
			public static String	Description	= "N�FUS C�ZDANI";
		}

		public static class Ehliyet {
			public static int		Id			= 2;
			public static String	Description	= "EHL�YET";
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
			public static String	Description	= "S�L�ND�";
		}

	}

	public static class MobileMessagingType {

		public static class Acil {
			public static int		Id			= 2;
			public static String	Description	= "AC�L";
		}

		public static class Onemli {
			public static int		Id			= 4;
			public static String	Description	= "�NEML�";
		}

		public static class Bilgi {
			public static int		Id			= 5;
			public static String	Description	= "B�LG�";
		}

	}

	public static class PickUpFeedBackStatus {

		public static class AlimBasarili {
			public static int		Id			= 1;
			public static String	Description	= "ALIM BA�ARILI";
		}

		public static class AlimBasarisiz {
			public static int		Id			= 2;
			public static String	Description	= "ALIM BA�ARISIZ";
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
