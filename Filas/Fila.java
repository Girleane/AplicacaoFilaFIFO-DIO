package Filas;

public class Fila<T> {
    private No<T> refIn;

    public Fila() {
        this.refIn = null;
    }

    public boolean isEmpty() {
        return refIn == null;
    }

    public void enqueue(T obj) {
        No<T> novoNo = new No<>(obj);
        novoNo.setRefNo(refIn);
        refIn = novoNo;
    }

    public Object dequeue() {

        if (!isEmpty()) {
            No<T> primeiroNo = refIn;
            No<T> noAuxiliar = refIn;

            while (true) {
                if (primeiroNo.getRefProximoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public Object first() {

        if (!isEmpty()) {
            No<T> firstNo = refIn;
            while (true) {
                if (firstNo.getRefProximoNo() != null) {
                    firstNo = firstNo.getRefProximoNo();
                } else {
                    break;
                }
            }
            return firstNo.getObject();
        }
        return null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No<T> noAuxiliar = refIn;

        if (!isEmpty()) {
            while (true) {
                stringRetorno += "[No {objeto = " + noAuxiliar.getObject() + "}]---->";

                if (noAuxiliar.getRefProximoNo() != null) {
                    noAuxiliar = noAuxiliar.getRefProximoNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }

        } else {
            stringRetorno = "null";
        }

        return stringRetorno;
    }
}
