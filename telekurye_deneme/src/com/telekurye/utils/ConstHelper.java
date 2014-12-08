package com.telekurye.utils;

import java.util.ArrayList;

public class ConstHelper {

	public static class BuildingType {

		public static final ArrayList<String> Description() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("< SE��M YAPINIZ >");
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
			list.add("< SE��M YAPINIZ >");
			list.add("KEND�S�");
			list.add("SEKRETER");
			list.add("F�RMA �ALI�ANI");
			list.add("F�RMA YETK�L�S�");
			list.add("F�RMA G�VENL�K ELEMANI");
			list.add("MUHABERAT");
			list.add("DANI�MA");
			list.add("B�R�M M�D�R�");
			list.add("MUHASEBE SORUMLUSU");
			list.add("BANKA �UBE G�REVL�S�");
			list.add("HANEDEK� �AHIS");
			list.add("1. DERECE YAKIN");
			list.add("KOM�U");
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
			list.add("< SE��M YAPINIZ >");
			list.add("TESL�M ED�LD�");
			list.add("EVDE YOK - HABER KA�IDI BIRAKILDI");
			list.add("�ADE: ADRES HATALI-EKS�K-YETERS�Z");
			list.add("�ADE: ADRESTE TANINMIYOR");
			list.add("�ADE: TA�INMI�");
			list.add("�ADE: DA�ITIMA �Z�N VER�LM�YOR");
			list.add("�ADE: KABUL ED�LM�YOR");
			list.add("�ADE: GE�ERL� K�ML�K G�STERMED�");
			list.add("�ADE: VEFAT ETM��");
			list.add("�ADE: TAY�N� �IKMI�-��TEN AYRILMI�");
			list.add("KURYE DEV�R");
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
			list.add("< SE��M YAPINIZ >");
			list.add("N�FUS C�ZDANI");
			list.add("EHL�YET");
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
			list.add("< SE��M YAPINIZ >");
			list.add("OKUNMADI");
			list.add("OKUNDU");
			list.add("S�L�ND�");
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
			list.add("< SE��M YAPINIZ >");
			list.add("AC�L");
			list.add("�NEML�");
			list.add("B�LG�");
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
			list.add("< SE��M YAPINIZ >");
			list.add("ALIM BA�ARILI");
			list.add("ALIM BA�ARISIZ");
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
