package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.serviceimpl.patternserviceimpl;

@Service
public class patternservice implements patternserviceimpl {

	public String sk = "";

	public String pattern(int size, String type) {

		switch (type) {
		case "sp":
			return square(size);
		case "tp":
			return triangle(size);
		case "bp":
			return butterfly(size);
		case "matrix":
			return matrix(size);
		case "invert":
			return invertfloydtriangle(size);
		case "rotate":
			return rotation(size);
		case "spiral":
			return spiral(size);

		}

		return "Please Enter Correct Value";

	}

	@Override
	public String square(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sk += "*";
			}
			sk += "\n";
		}
		return sk;
	}

	@Override
	public String triangle(int rows) {

		for (int i = 0; i < rows; i++) {
			// System.out.print(" "); //print space

			for (int j = 0; j <= i; j++) // inner loop for number of columns
			{
				// System.out.print("* "); //print star
				sk += "*" + "  ";
			}

			// System.out.println(); //ending line after each row
			sk += "\n";
		}

		for (int i = 0; i < rows - 1; i++) {

			// System.out.print(" ");

			for (int j = i; j < rows - 1; j++) {
				// System.out.print("* ");
				sk += "*" + "   ";
			}
			// System.out.println();
			sk += "\n";

		}
		return sk;
	}

	@Override
	public String butterfly(int size) {
		int r = size;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j <= i; j++) {
				// System.out.print("*");
				sk += "*";
			}
			for (int z = i + 2; z < r * 2 - i; z++) {
				// System.out.print(" ");
				sk += "  ";
			}
			for (int x = 0; x <= i; x++) {
				// System.out.print("*");
				sk += "*";
			}
			// System.out.println();
			sk += "\n";
		}

		for (int i = 0; i < r - 1; i++) {
			for (int j = i; j < r - 1; j++) {
				// System.out.print("*");
				sk += "*";
			}

			for (int z = 0; z <= i + i + 1; z++) {

				// System.out.print(" ");
				sk += "  ";
			}
			for (int x = i; x < r - 1; x++) {
				// System.out.print("*");
				sk += "*";
			}

			// System.out.println();
			sk += "\n";

		}

		return sk;
	}

	@Override
	public String rotation(int r) {

		for (int i = 1; i <= r; i++) {
			for (int z = i; z <= r; z++)

			{
				// System.out.print(z +" ");
				sk += z + "   ";
			}
			for (int j = 1; j < i; j++) {
				// System.out.print(j+" ");
				sk += j + "   ";
			}
			sk += "\n";

			// System.out.println();
		}

		return sk;
	}

	@Override
	public String matrix(int r) {

		int rc = r / 4 + 1;
		int a = 1;
		int space = rc - 2;
		int c = r;
		int last = 0;
		int last1 = 0;
		int s = r;

		for (int i = 0; i < rc; i++) {

			for (int j = 0; j < rc; j++) {
				if (i == 0) {
					// System.out.print(a + " ");
					sk += a + "    ";
					last1 = a;
					a++;
				} else if (j == 0 && i != rc - 1) {
					// System.out.print(c + " ");
					sk += c + "    ";
					last = c;
					c--;
					for (int z = 1; z <= space; z++) {
						// System.out.print(" ");
						sk += "    ";
					}

				} else if (i == rc - 1) {
					if (space == 0) {
						// System.out.print(s + " ");
						sk += s + "    ";
						s--;
					} else {

						last--;
						// System.out.print(last + " ");
						sk += last + "    ";
					}
				} else if (j == rc - 1) {
					last1++;
					// System.out.print(last1 + " ");
					sk += last1 + "    ";

					// last column
				}
			}
			// System.out.println( );
			sk += "\n";

		}

		return sk;
	}

	@Override
	public String invertfloydtriangle(int a) {

		int c, b;
		c = a * (a + 1) / 2;

		for (int i = 0; i < a; i++) {
			b = c--;
			int dec = a - 1;
			for (int j = 0; j < a - i; j++) {

				// System.out.print(b + " ");
				sk += b + " ";
				b = b - dec;
				dec--;

			}

			// System.out.println();
			sk += "\n";
		}

		return sk;
	}

	@Override
	public String spiral(int len) {
		int len_2 = len;
		int[][] arr = new int[len][len];
		int in = 1;
		int count = 0;

		while (len >= 0) {

			boolean flag = true;
			int temp = 0;
			int col = (len * 4 - 4) * (count + 1);

			for (int i = count; i < len; i++) {
				for (int j = count; j < len; j++) {

					if (i == count) {
						arr[i][j] = in++;
					} else if (j == count && i != len - 1) {
						if (flag) {
							temp = col;
							flag = false;
						}

						arr[i][j] = col--;

					} else if (j == len - 1 && i != len - 1) {
						arr[i][j] = in++;
					} else if (i == len - 1) {
						arr[i][j] = col--;
					}
				}
			}

			len--;
			count++;
			in = ++temp;

		}

		for (int i = 0; i < len_2; i++) {
			for (int j = 0; j < len_2; j++) {
				sk += arr[i][j] + "   ";
				// System.out.print(arr[i][j]+" ");
			}
			sk += "\n";
			// System.out.println();
		}
		return sk;
	}

	public String namepattern(String name) {
		
		
		name = name.toUpperCase();
		String temp="";
		char c;
		String value ="";
		
		for(int i=0;i<name.length();i++) {
			c=name.charAt(i);
		
		
		switch (c) {
		case 'A':
			temp=A(c);
			break;
		case 'B':
			temp=B(c);
			break;
		case 'C':
			temp=C(c);
			break;
		case 'D':
			temp=D(c);
			break;
		case 'E':
			temp= E(c);
			break;
		case 'F':
			temp= F(c);
			break;
		case 'G':
			temp= G(c);
			break;
		case 'H':
			temp= H(c);
			break;
		case 'I':
			temp= I(c);
			break;
		case 'J':
			temp= J(c);
			break;
		case 'K':
			temp= K(c);
			break;
		case 'L':
			temp= L(c);
			break;
		case 'M':
			temp= M(c);
			break;
		case 'N':
			temp= N(c);
			break;
		case 'O':
			temp= O(c);
			break;
		case 'P':
			temp= P(c);
			break;
		case 'Q':
			temp= Q(c);
			break;
		case 'R':
			temp= R(c);
			break;
		case 'S':
			temp= S(c);
			break;
		case 'T':
			temp= T(c);
			break;
		case 'U':
			temp= U(c);
			break;
		case 'V':
			temp= V(c);
			break;
		case 'W':
			temp= W(c);
			break;
		case 'X':
			temp= X(c);
			break;
		case 'Y':
			temp= Y(c);
			break;
		case 'Z':
			temp= Z(c);
			break;
		
		}
		value+=temp+" \n---------------\n";
		//value+=temp;
	}
		return value;
		

		
		
	}

	@Override
	public String A(char c) {
		sk=       "      *\n"
				+ "    *  *\n"
				+ "  *  *  *\n"
				+ " *        *";
		return sk;
	}

	@Override
	
	public String B(char c) {
		sk =      "****\n"
				+ "*     *\n"
				+ "****\n"
				+ "*     *\n"
				+ "****";
		return sk;
	}

	@Override
	public String C(char c) {
		sk=       "  ****\n"
				+ " *\n"
				+ "*\n"
				+ " *\n"
				+ "  ****";
		return sk;
	}

	@Override
	public String D(char c) {
		sk =      "***\n"
				+ "*     *\n"
				+ "*      *\n"
				+ "*     *\n"
				+ "***";
		return sk;
	}
	

	@Override
	public String E(char c) {
		sk =      "*****\n"
				+ "*\n"
				+ "*****\n"
				+ "*\n"
				+ "*****";
		return sk;
	}

	@Override
	public String F(char c) {
		sk=    "*****\n"
			 + "*\n"
			 + "*****\n"
			 + "*\n"
			 + "*";
		return sk;
	}

	@Override
	public String G(char c) {
		sk=       "*****\n"
				+ "*      *\n"
				+ "*     \n"
				+ "*  ***\n"
				+ "***  *";
				
		return sk;
	}

	@Override
	public String H(char c) {
	    sk=       "*      *\n"
	    		+ "*      *\n"
	    		+ "*****\n"
	    		+ "*      *\n"
	    		+ "*      *";
		return sk;
	}

	@Override
	public String I(char c) {
		sk =      "*****\n"
				+ "    *\n"
				+ "    *\n"
				+ "    *\n"
				+ "*****";
		return sk;
	}

	@Override
	public String J(char c) {
		sk=       "*******\n"
				+ "      *\n"
				+ "      *\n"
				+ "*    *\n"
				+ "****";
		return sk;
	}

	

	@Override
	public String K(char c) {
		sk=       "*     *\n"
				+ "*   *\n"
				+ "* *\n"
				+ "*   *\n"
				+ "*     *";
		return sk;
	}
	@Override
	public String L(char c) {
		sk=       "*\n"
				+ "*\n"
				+ "*\n"
				+ "*\n"
				+ "******";
				
		return sk;
	}

	@Override
	public String M(char c) {
		sk=       "*          *\n"
				+ "*  *  *  *\n"
				+ "*    *    *\n"
				+ "*          *\n"
				+ "*          *";
		return sk;
	}

	@Override
	public String N(char c) {
		sk =      "*      *\n"
				+ "* *   *\n"
				+ "*   * *\n"
				+ "*      *";	
		return sk;
	}

	@Override
	public String O(char c) {
		sk =      " *****\n"
				+ "*        *\n"
				+ "*        *\n"
				+ "*        *\n"
				+ " *****";	
		return sk;
	}

	@Override
	public String P(char c) {
		sk =      "*****\n"
				+ "*       *\n"
				+ "*****\n"
				+ "*\n"
				+ "*";	
		return sk;
	}

	@Override
	public String Q(char c) {
		sk =      " *****\n"
				+ "*        *\n"
				+ "*        *\n"
				+ "*        * *\n"
				+ " *****    *";	
		return sk;
	}

	@Override
	public String R(char c) {
		sk =      "****\n"
				+ "*     *\n"
				+ "***\n"
				+ "*    *\n"
				+ "*     *";
		return sk;
	}

	@Override
	public String S(char c) {
		 sk =     "****\n"
		 		+ "*   \n"
		 		+ "****\n"
		 		+ "      *\n"
		 		+ "****";
		return sk;
	}

	@Override
	public String T(char c) {
		sk =      "*******\n"
				+ "      *\n"
				+ "      *\n"
				+ "      *\n"
				+ "      *";	
		return sk;
	}

	@Override
	public String U(char c) {
		sk =      "*        *\n"
				+ "*        *\n"
				+ "*        *\n"
				+ "*        *\n"
				+ " *****";	
		return sk;
	}

	@Override
	public String V(char c) {
		sk =      "*       *\n"
				+ " *     *\n"
				+ "  *   *\n"
				+ "   * *\n"
				+ "    *";	
		return sk;
	}

	@Override
	public String W(char c) {
		sk =      "*           *\n"
				+ "*           *\n"
				+ " *   *    *\n"
				+ "  * * * *\n"
				+ "   *    *";	
		return sk;
	}

	@Override
	public String X(char c) {
		sk =      "*        *\n"
				+ "  *    *\n"
				+ "     *\n"
				+ "  *    *\n"
				+ "*        *";	
		return sk;
	}

	@Override
	public String Y(char c) {
		sk =      "*     *\n"
				+ " *   *\n"
				+ "   *\n"
				+ "  *\n"
				+ " *";	
		return sk;
	}

	@Override
	public String Z(char c) {
		sk =      "****\n"
				+ "     *\n"
				+ "   *\n"
				+ " *\n"
				+ "****";	
		return sk;
	}

}
