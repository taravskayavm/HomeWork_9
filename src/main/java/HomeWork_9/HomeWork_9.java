package HomeWork_9;


    class Exceptions extends Exception {
        Exceptions (String message) {
            super(message);
        }
    }

    class MyArrayDataException extends Exceptions {

        MyArrayDataException(int a, int b) {
            super(String.format("Неверные данные находятся в ячейке \n%s\n", a, b));
        }
    }

    class MyArraySizeException extends Exceptions {

        MyArraySizeException() {
            super("Некорректный размер массива.");
        }
    }

    class Converter {

        static int strConverter(String[][] strArray)
            throws MyArraySizeException, MyArrayDataException {

            int sum = 0;

            if (4 != strArray.length) throw new MyArraySizeException();
            for (int i = 0; i < strArray.length; i++) {
                if (4 != strArray[i].length) throw new MyArraySizeException();
                for (int k = 0; k < strArray[i].length; k++) {
                    try {
                        sum += Integer.parseInt(strArray[i][k]);
                    } catch (NumberFormatException e) {

                        throw new MyArrayDataException(i, k);
                    }
                }
            }

            return sum;
        }
    }



    public class HomeWork_9 {

        public static void main (String[] args) {

        String[][] correctMatrix = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "8"}
        };
        String[][] wrongSizeMatrix = {
                {"1", "2", "0", "3"},
                {"6", "4", "1", "5"},
                {"9", "2", "7", "4"},
                {"0", "2"}
        };
        String[][] wrongCharMatrix = {
                {"1", "9", "2", "3"},
                {"6", "1", "5", "7"},
                {"2", "Z", "7", "6"},
                {"1", "9", "4", "5"}
        };


        try {
            System.out.println("Вариант 1:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(correctMatrix) + ".\n");
        }
        catch (Exceptions e) {
            e.getMessage();
        }

        try {
            System.out.println("Вариант 2:");
            System.out.println("Сумма элементов массива равна " + Converter.strConverter(wrongSizeMatrix) + ".\n");
        }
        catch (Exceptions e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Вариант 3:");
            System.out.println("Сумма элементов массива равна " + Converter.strConverter(wrongCharMatrix) + ".\n");
        }
        catch (Exceptions e) {
            System.out.println(e.getMessage());
        }

        }

    }
