package mviel.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager fm;
    FrameLayout f2;
    private FragmentTransaction ft;
    private OnFragmentInteractionListener mListener1;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);
        f2 = (FrameLayout) v.findViewById(R.id.canto_superior_dret);

        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fm = getFragmentManager();
                ft= fm.beginTransaction();
                fm.popBackStack();
                fm.popBackStack();

                return false;
            }
        });


        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getFragmentManager();
                ft = fm.beginTransaction();

                Toast.makeText(getContext(),"Has fet click en Fragment1",Toast.LENGTH_SHORT).show();


                if(!mListener1.estaFragment2EnActivity()) {
                    Toast.makeText(getContext(), "Mostrant Fragment2", Toast.LENGTH_SHORT).show();
                    ft.add(R.id.canto_superior_dret, Fragment2.newInstance("", ""));
                    ft.addToBackStack("fragmen1");


                }else{
                    Toast.makeText(getContext(), "Amagant Fragment2", Toast.LENGTH_SHORT).show();
                    fm.popBackStack();

                }
                ft.commit();
                }
            }
        );
        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener1 = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener1 = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

        boolean estaFragment2EnActivity();
    }
}
