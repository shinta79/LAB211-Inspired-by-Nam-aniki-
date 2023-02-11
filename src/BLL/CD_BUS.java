package BLL;

import DAL.CD_DAO;
import DTO.CD_DTO;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author giahu
 */
public class CD_BUS {

    private final CD_DAO dao = new CD_DAO();

    private final ArrayList<CD_DTO> list = new ArrayList();

    public CD_BUS() {
    }

    public ArrayList<CD_DTO> getList() {
        return list;
    }

    public boolean checkCD(CD_DTO cd) {
        return list.stream()
                .filter(d -> d.getID().equals(cd.getID()))
                .findFirst().isPresent();
    }

    public CD_DTO findCD(CD_DTO cd) throws NoSuchElementException {
        return list.stream()
                .filter(d -> d.getID().equals(cd.getID()))
                .findFirst().get();
    }

    public void addCD(CD_DTO cd) {
        if (checkCD(cd)) {
            throw new NullPointerException();
        } else {
            list.add(cd);
        }
    }

    public ArrayList<CD_DTO> searchCD(String str, String col) throws NoSuchElementException {
        ArrayList<CD_DTO> temp = null;
        switch (col) {
            case "Collection":
                temp = list.stream()
                        .filter(d -> d.getCollName().toLowerCase().contains(str.toLowerCase()))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort(Comparator
                        .comparing(CD_DTO::getCollName)
                        .thenComparing(CD_DTO::getTitle));
                break;
            case "Type":
                temp = list.stream()
                        .filter(d -> d.getType().toLowerCase().contains(str.toLowerCase()))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort(Comparator
                        .comparing(CD_DTO::getType)
                        .thenComparing(CD_DTO::getTitle));
                break;
            case "Title":
                temp = list.stream()
                        .filter(d -> d.getTitle().toLowerCase().contains(str.toLowerCase()))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort((CD_DTO cd1, CD_DTO cd2) -> (cd1.getTitle().compareToIgnoreCase(cd2.getTitle())) > 0 ? 1 : -1);
                break;
            case "Price":
                temp = list.stream()
                        .filter(d -> String.valueOf(d.getPrice()).contains(str))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort(Comparator
                        .comparing(CD_DTO::getPrice)
                        .thenComparing(CD_DTO::getTitle));
                break;
            case "ID":
                temp = list.stream()
                        .filter(d -> d.getID().toLowerCase().contains(str.toLowerCase()))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort(Comparator
                        .comparing(CD_DTO::getID));
                break;
            case "Year":
                temp = list.stream()
                        .filter(d -> String.valueOf(d.getYear()).contains(str))
                        .collect(Collectors.toCollection(ArrayList<CD_DTO>::new));

                temp.sort(Comparator
                        .comparing(CD_DTO::getYear)
                        .thenComparing(CD_DTO::getTitle));
                break;
        }
        return temp;
    }

    public void updateCD(CD_DTO cd) {
        CD_DTO dto = findCD(cd);
        dto.setCollName(cd.getCollName());
        dto.setPrice(cd.getPrice());
        dto.setTitle(cd.getTitle());
        dto.setType(cd.isType());
        dto.setYear(cd.getYear());
    }

    public void deleteCD(String id) throws NoSuchElementException {
        this.list.remove(findCD(new CD_DTO(id)));
    }

    public void loadData(String path) throws IOException, ClassNotFoundException {
        this.list.clear();
        this.list.addAll(dao.loadCD(path));
    }

    public void saveData(String path) throws IOException {
        dao.saveCD(path, this.getList());
    }
}
