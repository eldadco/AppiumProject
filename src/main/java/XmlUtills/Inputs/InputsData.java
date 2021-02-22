package XmlUtills.Inputs;

import java.util.HashMap;
import java.util.List;

public class InputsData {
    List<HashMap> data ;
    public InputsData()
    {
        XmlnputsReader xmlnputsReader = new XmlnputsReader();
        data = xmlnputsReader.getInputsFromXml();

    }
    public HashMap getDataByTestId(int index)
    {
        return data.get(index - 1);
    }

    public int getNumOfTests()
    {
        return data.size();
    }
}
