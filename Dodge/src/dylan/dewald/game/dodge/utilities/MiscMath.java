package dylan.dewald.game.dodge.utilities;

public class MiscMath {
		public static double getDistance(int xOne, int yOne, int xTwo, int yTwo){
				double result;
				result = Math.sqrt( (Math.pow(2,(xTwo - xOne) ) + Math.pow(2, ( yTwo - yOne))));
				return result;
		}
}
