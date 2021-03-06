package vasiliyloginov.weatherapp;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link secondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class secondFragment extends Fragment {

    public static final String PARCEL = "parcel";

    public static secondFragment create( Parcel parcel) {
        secondFragment f = new secondFragment(); // создание
// Передача параметра
        Bundle args = new Bundle();
        //args.putInt( "index" , index);
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }
    // Получить индекс из списка (фактически из параметра)
    //public int getIndex() {
      //  int index = getArguments().getInt( "index" , 0 );
        //return index;
    //}

    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public secondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment secondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static secondFragment newInstance(String param1, String param2) {
        secondFragment fragment = new secondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout. fragment_second ,container, false );

        TextView cityTextView = layout.findViewById(R.id.textViewCity);
        TextView tempTextView = layout.findViewById(R.id.textViewTemp);

        Parcel parcel = getParcel();

        cityTextView.setText(parcel.getCityName());
        tempTextView.setText(parcel.getTemperatureValue() + "°C");
        tempTextView.setTextSize(130);
        return layout;

        //TextView cityText = new TextView(getContext());
        //TextView tempText = new TextView(getContext());
        //String [] cities = getResources().getStringArray(R.array.cities);
        //String [] temp = getResources().getStringArray(R.array.temperature);
       // String txt = cities[getIndex()];
        //String temperature = temp[getIndex()];
      //  cityText.setText(txt);
       // tempText.setText(temperature + "°C");
      //  tempText.setTextSize(130);
      //  return tempText;
    }
}