package raf.rs.rafnews_web_2023.service;

import raf.rs.rafnews_web_2023.converter.NewsDTO_Converter;
import raf.rs.rafnews_web_2023.dto.news.NewsDTO;
import raf.rs.rafnews_web_2023.dto.news.NewsPreviewDTO;
import raf.rs.rafnews_web_2023.model.News;
import raf.rs.rafnews_web_2023.repository.api.NewsRepositoryAPI;

import javax.inject.Inject;
import java.util.List;

public class NewsService {
    @Inject
    CategoryService categoryService;
    @Inject
    private NewsRepositoryAPI newsRepository;
    @Inject
    private UserService userService;
    @Inject
    private CommentService commentService;

    public NewsService() {
        System.out.println(this);
    }

    public List<NewsPreviewDTO> allNews() {
        List<News> news = newsRepository.allNews();
        return NewsDTO_Converter
                .convertToNewsPreviewDTOList(
                        news,
                        userService.searchNewsAuthors(news),
                        categoryService.searchNewsCategories(news)
                );
    }

    public List<NewsPreviewDTO> newsForPage(int pageIndex, int pageSize) {
        List<News> news = newsRepository.newsForPage(pageIndex, pageSize);
        return NewsDTO_Converter
                .convertToNewsPreviewDTOList(
                        news,
                        userService.searchNewsAuthors(news),
                        categoryService.searchNewsCategories(news)
                );
    }

    public List<NewsPreviewDTO> newsInCategory(int categoryId) {
        List<News> news = newsRepository.newsInCategory(categoryId);
        return NewsDTO_Converter
                .convertToNewsPreviewDTOList(
                        news,
                        userService.searchNewsAuthors(news),
                        categoryService.searchNewsCategories(news)
                );
    }

    public NewsDTO findById(int id) {
        News news = newsRepository.findById(id);
        return NewsDTO_Converter
                .convertToNewsDTO(
                        news,
                        userService.searchAuthor(news),
                        categoryService.searchCategoryById(news.getCategoryId()),
                        commentService.commentsOnNews(news.getId())
                );
    }

    public NewsDTO addNews(News news) {
        news = newsRepository.addNews(news);

        return NewsDTO_Converter
                .convertToNewsDTO(
                        news,
                        userService.searchAuthor(news),
                        categoryService.searchCategoryById(news.getCategoryId()),
                        commentService.commentsOnNews(news.getId())

                );
    }

    public NewsPreviewDTO editNews(NewsPreviewDTO newsPreviewDTO) {
        News news = NewsDTO_Converter.convertToNews(newsPreviewDTO);
        news = newsRepository.addNews(news);

        return NewsDTO_Converter
                .convertToNewsPreviewDTO(
                        news,
                        userService.searchAuthor(news),
                        categoryService.searchCategoryById(news.getCategoryId())
                );
    }

    public void deleteNews(int id) {
        News news = new News();
        news.setId(id);
        newsRepository.deleteNews(news);
    }

    public List<News> newsByAuthor(int authorId) {
        return newsRepository.newsByAuthor(authorId);
    }

    public List<NewsPreviewDTO> filterSearch(int categoryId, String dateOrder, boolean trending, int pageIndex, int pageSize) {
        List<News> news = newsRepository.filterSearch(categoryId, dateOrder, trending, pageIndex, pageSize);
        return NewsDTO_Converter
                .convertToNewsPreviewDTOList(
                        news,
                        userService.searchNewsAuthors(news),
                        categoryService.searchNewsCategories(news)
                );
    }

    public void incrementVisitedCount(int newsId) {
        newsRepository.incrementVisitedCount(newsId);
    }
}
