import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Paste JSON input (type END in a new line when done):");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.trim().equalsIgnoreCase("END")) break;
            sb.append(line).append("\n");
        }
        String s = sb.toString();
        int n = Integer.parseInt(s.split("\"n\":")[1].split(",")[0].trim());
        int k = Integer.parseInt(s.split("\"k\":")[1].split("}")[0].trim());
        ArrayList<BigInteger> roots = new ArrayList<>();
        String[] parts = s.split("\\{");
        for (String part : parts) {
            if (part.contains("\"base\"") && part.contains("\"value\"")) {
                String bs = part.split("\"base\":")[1].split(",")[0].replace("\"","").trim();
                String vs = part.split("\"value\":")[1].split("}")[0].replace("\"","").trim();
                int base = Integer.parseInt(bs);
                BigInteger dec = new BigInteger(vs, base);
                roots.add(dec);
            }
        }
        BigInteger c = roots.get(0);
        System.out.println(c);
    }
}




// OUTPUT
TEST CASE -1:
  Paste JSON input (type END in a new line when done):
{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": {
        "base": "10",
        "value": "4"
    },
    "2": {
        "base": "2",
        "value": "111"
    },
    "3": {
        "base": "10",
        "value": "12"
    },
    "6": {
        "base": "4",
        "value": "213"
    }
}
END

  OUTPUT:
4

  
TEST CASE -2 :
Paste JSON input (type END in a new line when done):
{
"keys": {
    "n": 10,
    "k": 7
  },
  "1": {
    "base": "6",
    "value": "13444211440455345511"
  },
  "2": {
    "base": "15",
    "value": "aed7015a346d635"
  },
  "3": {
    "base": "15",
    "value": "6aeeb69631c227c"
  },
  "4": {
    "base": "16",
    "value": "e1b5e05623d881f"
  },
  "5": {
    "base": "8",
    "value": "316034514573652620673"
  },
  "6": {
    "base": "3",
    "value": "2122212201122002221120200210011020220200"
  },
  "7": {
    "base": "3",
    "value": "20120221122211000100210021102001201112121"
  },
  "8": {
    "base": "6",
    "value": "20220554335330240002224253"
  },
  "9": {
    "base": "12",
    "value": "45153788322a1255483"
  },
  "10": {
    "base": "7",
    "value": "1101613130313526312514143"
  }
}
END
OUTPUT : 
995085094601491
