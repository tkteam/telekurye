package com.telekurye.utils;

import java.util.ArrayList;

public class ConstHelper {

	public static class BuildingType {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("Ev");
			list.add("Apartman");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(2);
			return list;
		}

	}

	public static class DistributionMissionFeedbackRelation {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("KENDÝSÝ");
			list.add("SEKRETER");
			list.add("FÝRMA ÇALIÞANI");
			list.add("FÝRMA YETKÝLÝSÝ");
			list.add("FÝRMA GÜVENLÝK ELEMANI");
			list.add("MUHABERAT");
			list.add("DANIÞMA");
			list.add("BÝRÝM MÜDÜRÜ");
			list.add("MUHASEBE SORUMLUSU");
			list.add("BANKA ÞUBE GÖREVLÝSÝ");
			list.add("HANEDEKÝ ÞAHIS");
			list.add("1. DERECE YAKIN");
			list.add("KOMÞU");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(5);
			list.add(7);
			list.add(8);
			list.add(10);
			list.add(11);
			list.add(12);
			list.add(13);
			list.add(14);
			list.add(15);
			list.add(16);
			return list;
		}

	}

	public static class EndPointStatus {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("TESLÝM EDÝLDÝ");
			list.add("EVDE YOK - HABER KAÐIDI BIRAKILDI");
			list.add("ÝADE: ADRES HATALI-EKSÝK-YETERSÝZ");
			list.add("ÝADE: ADRESTE TANINMIYOR");
			list.add("ÝADE: TAÞINMIÞ");
			list.add("ÝADE: DAÐITIMA ÝZÝN VERÝLMÝYOR");
			list.add("ÝADE: KABUL EDÝLMÝYOR");
			list.add("ÝADE: GEÇERLÝ KÝMLÝK GÖSTERMEDÝ");
			list.add("ÝADE: VEFAT ETMÝÞ");
			list.add("ÝADE: TAYÝNÝ ÇIKMIÞ-ÝÞTEN AYRILMIÞ");
			list.add("KURYE DEVÝR");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(9);
			list.add(10);
			list.add(11);
			list.add(12);
			list.add(13);
			list.add(17);
			list.add(18);
			list.add(20);
			list.add(21);
			list.add(26);
			return list;
		}

	}

	public static class IdentityType {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("NÜFUS CÜZDANI");
			list.add("EHLÝYET");
			list.add("PASAPORT");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(2);
			list.add(3);
			return list;
		}

	}

	public static class MobileMessagingStatusType {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("OKUNMADI");
			list.add("OKUNDU");
			list.add("SÝLÝNDÝ");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(2);
			list.add(4);
			return list;
		}

	}

	public static class MobileMessagingType {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("ACÝL");
			list.add("ÖNEMLÝ");
			list.add("BÝLGÝ");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(2);
			list.add(4);
			list.add(5);
			return list;
		}

	}

	public static class PickUpFeedBackStatus {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SEÇÝM YAPINIZ >");
			list.add("ALIM BAÞARILI");
			list.add("ALIM BAÞARISIZ");
			list.add("ALIM YAPILAMAYACAK");
			return list;
		}

		public static final ArrayList<Integer> Id() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(1);
			list.add(2);
			list.add(4);
			return list;
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
