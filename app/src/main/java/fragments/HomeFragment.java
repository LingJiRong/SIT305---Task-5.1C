package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.task51c.R;
import adapters.NewsAdapter;
import models.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView topStoriesRecycler, newsRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        topStoriesRecycler = view.findViewById(R.id.recycler_top_stories);
        newsRecycler = view.findViewById(R.id.recycler_news);

        List<NewsItem> topStories = getSampleNews();
        List<NewsItem> newsList = getSampleNews();

        topStoriesRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        topStoriesRecycler.setAdapter(new NewsAdapter(topStories, getParentFragmentManager()));
        newsRecycler.setAdapter(new NewsAdapter(newsList, getParentFragmentManager()));

        return view;
    }

    private List<NewsItem> getSampleNews() {
        List<NewsItem> list = new ArrayList<>();
        list.add(new NewsItem("Economy shows signs of recovery", "Markets rebound after months of decline...", R.drawable.news1));
        list.add(new NewsItem("Political tension", "New diplomatic standoff raises concerns...", R.drawable.news2));
        list.add(new NewsItem("Weekly review: numbers tell the story of Australia’s recession", "Data shows economic slowdown and challenges ahead...", R.drawable.news3));
        list.add(new NewsItem("The ever changing relationship between media and politicians", "How press coverage continues to influence political outcomes...", R.drawable.news4));
        return list;
    }

}
