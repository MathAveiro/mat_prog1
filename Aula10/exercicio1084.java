import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1084 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma matrícula: ");
		String matricula = sc.nextLine();
		String[] patterns = new String[3];
		patterns[0] = "AA-00-00";
		patterns[1] = "00-AA-00";
		patterns[2] = "00-00-AA";
		boolean valido = false;
		for(int i = 0; i < patterns.length; i++) {
			if(matchPattern(matricula, patterns[i])) {
				valido = !valido;
				break;
			}
		}
		if(valido) out.println("A matrícula "+matricula+" é válida!");
		else out.println("A matrícula "+matricula+" não é válida!");
	}
	public static boolean matchPattern(String matricula, String pattern) {
		if(isLetter(matricula.charAt(0)) &&  isLetter(pattern.charAt(0))) {
			if(isLetter(matricula.charAt(1)) &&  isLetter(pattern.charAt(1))) {
				if(isDigit(matricula.charAt(3)) &&  isDigit(pattern.charAt(3))) {
					if(isDigit(matricula.charAt(4)) &&  isDigit(pattern.charAt(4))) {
						if(isDigit(matricula.charAt(6)) &&  isDigit(pattern.charAt(6))) {
							if(isDigit(matricula.charAt(7)) &&  isDigit(pattern.charAt(7))) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			if (isDigit(matricula.charAt(0)) &&  isDigit(pattern.charAt(0))) {
				if(isDigit(matricula.charAt(1)) &&  isDigit(pattern.charAt(1))) {
					if(isDigit(matricula.charAt(3)) &&  isDigit(pattern.charAt(3))) {
						if(isDigit(matricula.charAt(4)) &&  isDigit(pattern.charAt(4))) {
							if(isLetter(matricula.charAt(6)) &&  isLetter(pattern.charAt(6))) {
								if(isLetter(matricula.charAt(7)) &&  isLetter(pattern.charAt(7))) {
									return true;
								} else {
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else if (isLetter(matricula.charAt(3)) &&  isLetter(pattern.charAt(3))) {
						if(isLetter(matricula.charAt(4)) &&  isLetter(pattern.charAt(4))) {
							if(isDigit(matricula.charAt(6)) &&  isDigit(pattern.charAt(6))) {
								if(isDigit(matricula.charAt(7)) &&  isDigit(pattern.charAt(7))) {
									return true;
								} else {
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}