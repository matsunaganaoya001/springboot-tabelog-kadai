INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (1, '味噌カツ屋', 'don.jpg', '最寄り駅から徒歩10分。美味しい味噌カツが食べられます。', 2000, 1000, '10:00:00', '20:00:00', '073-0145', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (2, '手羽先屋', 'fried.jpg', '最寄り駅から徒歩10分。美味しい手羽先が食べられます。', 3000,1000, '10:00:00', '20:00:00', '030-0945', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (3, 'ひつまぶし屋', 'don.jpg', '最寄り駅から徒歩10分。美味しいひつまぶしが食べられます。', 8000,2000, '10:00:00', '20:00:00', '029-5618', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (4, '味噌おでん屋', 'oden.jpg', '最寄り駅から徒歩10分。美味しい味噌おでんが食べられます。', 4000,2000, '10:00:00', '20:00:00', '989-0555', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (5, 'どて煮屋', 'oden.jpg', '最寄り駅から徒歩10分。美味しいどて煮が食べられます。', 3000,1000, '10:00:00', '20:00:00', '018-2661', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (6, '味噌煮込みうどん屋', 'udon.jpg', '最寄り駅から徒歩10分。美味しい味噌煮込みうどんが食べられます。', 2000,1000, '10:00:00', '20:00:00', '999-6708', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (7, '名古屋コーチンの店', 'fried.jpg', '最寄り駅から徒歩10分。美味しい名古屋コーチン料理が食べられます。', 5000,2000, '10:00:00', '20:00:00', '969-5147', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (8, '小倉トースト屋', 'ramen.jpg', '最寄り駅から徒歩10分。美味しい小倉トーストが食べられます。', 1000,500, '10:00:00', '20:00:00', '310-0021', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (9, 'えび煎餅屋', 'washoku.jpg', '最寄り駅から徒歩10分。美味しいえび煎餅が食べられます。', 2000,500, '10:00:00', '20:00:00', '323-1101', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (10, 'ういろう屋', 'washoku.jpg', '最寄り駅から徒歩10分。美味しいういろうが食べられます。', 1000,200, '10:00:00', '20:00:00', '370-0806', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');
INSERT IGNORE INTO stores (id, name, image_name, description, price_high,price_low, businesshours_open,businesshours_close, postal_code, address, phone_number,regularholiday) VALUES (11, 'ういろう屋', 'washoku.jpg', '最寄り駅から徒歩10分。美味しいういろうが食べられます。', 1000,200, '10:00:00', '20:00:00', '370-0806', '愛知県名古屋市熱田区X-XX-XX', '012-345-678','火曜日');

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'サムライ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'サムライ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '侍 雅', 'サムライ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '侍 正保', 'サムライ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '侍 真由美', 'サムライ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '侍 安民', 'サムライ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '侍 章緒', 'サムライ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '侍 祐子', 'サムライ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (11, '侍 秋美', 'サムライ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (12, '侍 信平', 'サムライ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.samurai@example.com', 'password', 1, false);

-- reservationsテーブル
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (1, 1, 1, '2023-04-01',  2);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (2, 2, 1, '2023-04-01',  3);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (3, 3, 1, '2023-04-01',  4);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (4, 4, 1, '2023-04-01',  5);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (5, 5, 1, '2023-04-01',  6);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (6, 6, 1, '2023-04-01',  2);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (7, 7, 1, '2023-04-01',  3);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (8, 8, 1, '2023-04-01',  4);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (9, 9, 1, '2023-04-01',  5);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (10, 10, 1, '2023-04-01',  6);
INSERT IGNORE INTO reservations (id, store_id, user_id, reservation_date_time,  number_of_people) VALUES (11, 11, 1, '2023-04-01',  2);

-- ユーザーIDが1～12、ストアIDが1～11の組み合わせでお気に入り情報を追加
INSERT IGNORE INTO favorites (user_id, store_id)
SELECT u.id, s.id
FROM users u
CROSS JOIN stores s
WHERE u.id BETWEEN 1 AND 12
AND s.id BETWEEN 1 AND 11;

-- ユーザーIDが1～12、ストアIDが1～11の組み合わせでレビュー情報を追加
INSERT IGNORE INTO reviews (user_id, store_id, rating, comment)
SELECT u.id, s.id, NULL, NULL
FROM users u
CROSS JOIN stores s
WHERE u.id BETWEEN 1 AND 12
AND s.id BETWEEN 1 AND 11;


