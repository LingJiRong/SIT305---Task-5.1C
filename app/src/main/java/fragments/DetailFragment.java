package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.task51c.R;
import adapters.NewsAdapter;
import models.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESC = "desc";
    private static final String ARG_IMAGE = "image";

    public static DetailFragment newInstance(NewsItem item) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, item.getTitle());
        args.putString(ARG_DESC, item.getDescription());
        args.putInt(ARG_IMAGE, item.getImageResId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView title = view.findViewById(R.id.detail_title);
        TextView desc = view.findViewById(R.id.detail_description);
        ImageView image = view.findViewById(R.id.detail_image);
        RecyclerView relatedRecycler = view.findViewById(R.id.recycler_related);

        if (getArguments() != null) {
            title.setText(getArguments().getString(ARG_TITLE));
            desc.setText(getArguments().getString(ARG_DESC));
            image.setImageResource(getArguments().getInt(ARG_IMAGE));
        }

        relatedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        relatedRecycler.setAdapter(new NewsAdapter(getSampleRelated(), getParentFragmentManager()));

        return view;
    }

    private List<NewsItem> getSampleRelated() {
        List<NewsItem> list = new ArrayList<>();
        list.add(new NewsItem("Economy shows signs of recovery", "Markets rebound after months of decline...", R.drawable.news1));
        list.add(new NewsItem("Political tension", "New diplomatic standoff raises concerns...", R.drawable.news2));
        list.add(new NewsItem("Weekly review: numbers tell the story of Australia’s recession", "Data shows economic slowdown and challenges ahead...", R.drawable.news3));
        list.add(new NewsItem("The ever changing relationship between media and politicians", "How press coverage continues to influence political outcomes...", R.drawable.news4));
        return list;
    }

}
