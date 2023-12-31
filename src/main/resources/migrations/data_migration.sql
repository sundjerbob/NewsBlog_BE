use
raf_news;

INSERT INTO user (email, first_name, last_name, password, role, status)
VALUES ('john@example.com', 'Joma ', 'Arandjelovic', 'password1', 'CONTENT_VIEWER', 'ACTIVE'),
       ('jane@example.com', 'Milan', 'Milosevic', 'password2', 'ADMIN', 'DEACTIVATED'),
       ('michael@example.com', 'Mivan', 'Majer', 'password3', 'CONTENT_VIEWER', 'DEACTIVATED'),
       ('susan@example.com', 'Susan', 'Williams', 'password4', 'CONTENT_VIEWER', 'ACTIVE'),
       ('david@example.com', 'David', 'Brown', 'password5', 'CONTENT_CREATOR', 'DEACTIVATED'),
       ('sarah@example.com', 'Sarah', 'Jones', 'password6', 'ADMIN', 'ACTIVE'),
       ('robert@example.com', 'Robert', 'Garcia', 'password7', 'ADMIN', 'DEACTIVATED'),
       ('lisa@example.com', 'Lisa', 'Miller', 'password8', 'CONTENT_CREATOR', 'DEACTIVATED'),
       ('william@example.com', 'William', 'Davis', 'password9', 'CONTENT_CREATOR', 'DEACTIVATED'),
       ('linda@example.com', 'Linda', 'Rodriguez', 'password10', 'CONTENT_CREATOR', 'ACTIVE'),
       ('christopher@example.com', 'Christopher', 'Martinez', 'password11', 'CONTENT_VIEWER', 'ACTIVE'),
       ('karen@example.com', 'Karen', 'Hernandez', 'password12', 'CONTENT_CREATOR', 'DEACTIVATED'),
       ('matthew@example.com', 'Matthew', 'Lopez', 'password13', 'CONTENT_CREATOR', 'ACTIVE'),
       ('amy@example.com', 'Amy', 'Gonzalez', 'password14', 'ADMIN', 'DEACTIVATED'),
       ('andrew@example.com', 'Andrew', 'Wilson', 'password15', 'CONTENT_VIEWER', 'ACTIVE'),
       ('emily@example.com', 'Emily', 'Anderson', 'password16', 'CONTENT_VIEWER', 'DEACTIVATED'),
       ('user17@example.com', 'User17', 'Surname17', 'password17', 'ADMIN', 'ACTIVE'),
       ('user18@example.com', 'User18', 'Surname18', 'password18', 'CONTENT_CREATOR', 'ACTIVE'),
       ('user19@example.com', 'User19', 'Surname19', 'password19', 'ADMIN', 'ACTIVE'),
       ('user20@example.com', 'User20', 'Surname20', 'password20', 'CONTENT_VIEWER', 'DEACTIVATED');
-- ---------------------------------------------------------------------------------------------------

INSERT INTO category (name, description)
VALUES ('Technology', 'Explore the latest advancements in technology.'),
       ('Sports', 'Get updates on your favorite sports and athletes.'),
       ('Fashion', 'Discover the latest fashion trends and styles.'),
       ('Travel', 'Plan your next adventure with travel tips and recommendations.'),
       ('Food', 'Indulge in delicious recipes and culinary delights.'),
       ('Health', 'Stay informed about health and wellness topics.'),
       ('Business', 'Get insights into the world of business and entrepreneurship.'),
       ('Music', 'Enjoy the latest music releases and artist news.'),
       ('Movies', 'Stay up-to-date with the world of movies and cinema.'),
       ('Science', 'Uncover the wonders of science and scientific discoveries.'),
       ('Politics', 'Stay informed about political news and events.'),
       ('Fitness', 'Achieve your fitness goals with workout tips and advice.'),
       ('Art', 'Explore the world of art and artistic creations.'),
       ('Science Fiction', 'Immerse yourself in the realm of science fiction.'),
       ('Home Decor', 'Discover interior design ideas and home decoration inspiration.'),
       ('Nature', 'Appreciate the beauty of nature and environmental conservation.'),
       ('Books', 'Explore the world of literature and book recommendations.'),
       ('Photography', 'Capture moments with photography tips and techniques.'),
       ('History', 'Uncover fascinating stories from the past.'),
       ('Gaming', 'Stay updated on the latest gaming news and releases.');
-- ----------------------------------------------------------------------------------------------------

INSERT INTO news (title, content, visited, creation_time, author_id, category_id)
VALUES ('Breaking BAD: New Discoveries in Space',
        'A blog (a truncation of "weblog") is a se pitate koji tip treninga je najbolji za Vas, a čuli ste i videli najrazličitije savete na internetu, od porodice, prijatelja ili poznanika, te Vam sve te informacije ne pomažu ni najmanje - tu smo da Vam pomognemo. Kontaktirajte nas i zakažite sastanak sa našim trenerima ili popunite "pametni" upitnik koji će Vam u odnosu na date odgovore predložiti nekoliko vrsta treninga koji bi za Vas bili dobra opcja.
 the World Wide Web consisting of discrete, often informal diary-style text entries (posts). Posts are typically displayed in reverse chronological order so that the most recent post appears first, at the top of the web page.',
        97, '2023-11-14 12:30:00', 1, 3),
       ('Healthy Recipes for a Balanced Diet', 'Try these dAnyone can connect with their audience through blogging and enjoy the myriad benefits that blogging provides: organic traffic from search engines, promotional content for social media, and recognition from a new audience you haven’t tapped into yet.

If you’ve heard about blogging but are a beginner and don’t know where to start, the time for excuses is over. Not only can you create an SEO-friendly blog, but we’ll cover how to write and manage your business''s blog as well as provide helpful templates to simplify your blogging efforts selicious and nutritious recipes for a healthier lifestyle.',
        3, '2023-05-15 09:45:00', 15, 7),
       ('Interview with Bestselling Author', 'Get an exclusive interview with the author of the latest bestseller.', 0,
        '2023-07-01 15:20:00', 6, 10),
       ('Art Exhibition: Exploring Colors and Textures',
        'Visit the art exhibition showcasing vibrant colors and unique textures.', 54, '2023-06-21 18:10:00', 12, 5),
       ('Tech News: Latest Gadgets and Innovations', 'Stay updAnyone can connect with their audience through blogging and enjoy the myriad benefits that blogging provides: organic traffic from search engines, promotional content for social media, and recognition from a new audience you haven’t tapped into yet.

If you’ve heard about blogging but are a beginner and don’t know where to start, the time for excuses is over. Not only can you create an SEO-friendly blog, but we’ll cover how to write and manage your business''s blog as well as provide helpful templates to simplify your blogging efforts.ated on the latest technology trends and gadgets.',
        1234, '2023-05-29 10:05:00', 9, 1),
       ('Movie Review: Blockbuster Hit or Flop?',
        'Read our review of the highly anticipated movie that everyone is talking about.', 231, '2023-06-05 16:45:00',
        4, 9),
       ('Travel Guide: Hidden Gems in Europe', 'Discover the hiAnyone can connect with their audience through blogging and enjoy the myriad benefits that blogging provides: organic traffic from search engines, promotional content for social media, and recognition from a new audience you haven’t tapped into yet.

If you’ve heard about blogging but are a beginner and don’t know where to start, the time for excuses is over. Not only can you create an SEO-friendly blog, but we’ll cover how to write and manage your business''s blog as well as provide helpful templates to simplify your blogging efforts.dden gems and off-the-beaten-path destinations in Europe.',
        32414, '2023-06-12 14:55:00', 18, 2),
       ('Sports Update: Exciting Matches and Upsets', 'Get the latest updates on sports events and thrilling matches.',
        986, '2023-06-17 11:25:00', 5, 6),
       ('Fashion Trends: What to Wear This Season',
        'Explore the latest fashion trends and style inspirations for the current season.', 695, '2023-06-10 13:40:00',
        11, 4),
       ('Health and Wellness Tips: Stay Fit and Healthy',
        'Learn valuable tips and advice for maintaining a healthy lifestyle.', 432, '2023-05-25 07:55:00', 7, 8),
       ('Tech Breakthrough: New AI Algorithm', 'A groundbreaking AI algorithm has revolutionized the tech industry.',
        987, '2023-06-29 19:30:00', 14, 3),
       ('Exclusive Interview with Celebrity Chef', 'Get insights fromAnyone can connect with their audience through blogging and enjoy the myriad benefits that blogging provides: organic traffic from search engines, promotional content for social media, and recognition from a new audience you haven’t tapped into yet.

If you’ve heard about blogging but are a beginner and don’t know where to start, the time for excuses is over. Not only can you create an SEO-friendly blog, but we’ll cover how to write and manage your business''s blog as well as provide helpful templates to simplify your blogging efforts. a renowned celebrity chef about culinary secrets.',
        0, '2023-07-03 08:15:00', 2, 7),
       ('Science News: Latest Discoveries and Research',
        'Stay informed about the latest scientific breakthroughs and research findings.', 45, '2023-05-18 17:20:00', 17,
        10),
       ('Music Festival: Unforgettable Performances and Vibes',
        'Experience the energy and excitement of a music festival with top-notch performances.', 78,
        '2023-06-23 11:50:00', 3, 5),
       ('Business Insights: Strategies for Success', 'Learn Anyone can connect with their audience through blogging and enjoy the myriad benefits that blogging provides: organic traffic from search engines, promotional content for social media, and recognition from a new audience you haven’t tapped into yet.

If you’ve heard about blogging but are a beginner and don’t know where to start, the time for excuses is over. Not only can you create an SEO-friendly blog, but we’ll cover how to write and manage your business''s blog as well as provide helpful templates to simplify your blogging efforts.valuable business strategies from industry experts and successful entrepreneurs.',
        456, '2023-06-07 09:10:00', 10, 1),
       ('Book Review: Must-Read Novels of the Year',
        'Discover the must-read novels that have captivated readers worldwide.', 876, '2023-06-15 14:25:00', 19, 9),
       ('Adventure Travel: Thrilling Destinations and Activities',
        'Embark on an adventurous journey to breathtaking destinations and thrilling activities.', 45536,
        '2023-07-02 16:35:00', 1, 2),
       ('Gaming News: Latest Releases and Updates',
        'Stay updated on the latest gaming news, releases, and exciting updates.', 7876, '2023-05-28 13:15:00', 13, 6),
       ('Beauty Tips: Skincare and Makeup Advice',
        'Get beauty tips and tricks for flawless skincare and stunning makeup looks.', 43634, '2023-06-13 10:40:00', 16,
        4),
       ('Fitness and Exercise: Achieve Your Haealth Goals',
        'Find inspiration and guidance to achieve your fitness and health goals.', 8778, '2023-06-18 12:50:00', 20, 8);

-- ----------------------------------------------------------------------------------------------------------------------

INSERT INTO tag (name)
VALUES ('Technology'),
       ('Fashion'),
       ('Sports'),
       ('Food'),
       ('Travel'),
       ('Music'),
       ('Art'),
       ('Health'),
       ('Science'),
       ('Business'),
       ('Gaming'),
       ('Books'),
       ('Movies'),
       ('Fitness'),
       ('Nature'),
       ('Photography'),
       ('Cars'),
       ('Pets'),
       ('Education'),
       ('Cooking');
-----------------------------------------------------------------------------------------------------

INSERT INTO news_tag (news_id, tag_id)
VALUES (1, 3),
       (1, 5),
       (2, 2),
       (2, 6),
       (3, 4),
       (3, 7),
       (4, 1),
       (4, 8),
       (5, 2),
       (5, 9),
       (6, 3),
       (6, 10),
       (7, 1),
       (7, 11),
       (8, 4),
       (8, 12),
       (9, 5),
       (9, 13),
       (10, 2),
       (10, 14);
-- ------------------------------------------------------------------------------------------------
INSERT INTO comment (content, creation_time, author_id, news_id)
VALUES ('Great article!', '2023-06-01 10:23:45', 1, 2),
       ('Interesting read!', '2023-06-02 14:56:32', 3, 1),
       ('Nice work!', '2023-06-03 09:12:18', 2, 3),
       ('Well written!', '2023-06-04 16:45:27', 4, 1),
       ('Informative content.', '2023-06-05 11:30:55', 2, 4),
       ('I disagree with some points.', '2023-06-06 08:17:39', 5, 3),
       ('Looking forward to more!', '2023-06-07 13:40:12', 1, 5),
       ('Thought-provoking article.', '2023-06-08 15:22:06', 3, 4),
       ('Well articulated.', '2023-06-09 12:10:57', 4, 2),
       ('Thanks for sharing!', '2023-06-10 09:35:24', 5, 1),
       ('I have a question...', '2023-06-11 17:55:38', 2, 5),
       ('Impressive work!', '2023-06-12 14:48:19', 3, 2),
       ('Engaging content!', '2023-06-13 11:27:53', 4, 3),
       ('Can\'t wait for the next part!', '2023-06-14 16:15:40', 5, 4),
       ('Well researched.', '2023-06-15 10:03:29', 1, 3),
       ('I learned something new.', '2023-06-16 13:20:17', 2, 1),
       ('Good job!', '2023-06-17 09:58:44', 4, 5),
       ('Impressed by the quality.', '2023-06-18 15:33:51', 5, 2),
       ('Insightful analysis.', '2023-06-19 12:05:36', 1, 4),
       ('Enjoyable read!', '2023-06-20 11:14:22', 3, 5);
