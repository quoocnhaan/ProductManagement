
import controller.DAO.ImagesDAO;
import controller.DAO.InventoryDAO;
import controller.DAO.ProductDAO;
import controller.DAO.WishesDAO;
import controller.DAOImp.ImagesDAOImp;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.ProductDAOImp;
import controller.DAOImp.WishesDAOImp;
import controller.Functional.Functional;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import model.Images;
import model.Inventory;
import model.Product;
import model.Wishes;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class UpdateDatabase {

//    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
////
////            Date date = Date.valueOf(LocalDate.now());
////
////            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
////            ProductDAO productDAO = new ProductDAOImp(session);
////            
////            Product product = productDAO.get(88);
////
////            System.out.println(inventoryDAO.getOpeningInventory(product, date));
//
////            String[] lines = {
////                "Happy New Year! May this year bring you endless joy and opportunities.", // Jan 1
////                "A fresh start, may today be the beginning of a wonderful journey.", // Jan 2
////                "May your day be filled with light, laughter, and new adventures.", // Jan 3
////                "You are the author of your day, write it beautifully.", // Jan 4
////                "Let today be a reminder of how strong and capable you are.", // Jan 5
////                "Every sunrise brings a new hope, make today count.", // Jan 6
////                "Take a deep breath, embrace the day with positivity.", // Jan 7
////                "Your kindness today will shine brighter than the sun.", // Jan 8
////                "May your efforts bring you closer to your dreams.", // Jan 9
////                "You are worthy of happiness and success.", // Jan 10
////                "Believe in your power to make today great.", // Jan 11
////                "Cherish the small victories and keep moving forward.", // Jan 12
////                "A new day, a new chance to create beautiful memories.", // Jan 13
////                "Gratitude is the key to unlocking joy today.", // Jan 14
////                "Focus on what matters most, let the rest fade away.", // Jan 15
////                "Today is a blank page, write your best story.", // Jan 16
////                "Let your heart be light, and your spirit bright.", // Jan 17
////                "May your day be filled with meaningful moments.", // Jan 18
////                "A small act of kindness can change someone’s entire day.", // Jan 19
////                "Keep your focus on the good, and the good will multiply.", // Jan 20
////                "Find joy in the little things today.", // Jan 21
////                "Let go of stress and embrace the peace within.", // Jan 22
////                "On our anniversary, remember that every day with you is special.", // Jan 23 (Your Anniversary)
////                "May today bring you one step closer to your dreams.", // Jan 24
////                "Your positivity is contagious, spread it wherever you go.", // Jan 25
////                "Make today a masterpiece of love, laughter, and joy.", // Jan 26
////                "Celebrate your uniqueness today, you are one of a kind.", // Jan 27
////                "You have the power to create a beautiful day for yourself.", // Jan 28
////                "Reflect on the good, let it fuel your spirit for the day.", // Jan 29
////                "Start today with a smile and let it guide your way.", // Jan 30
////                "You are loved and appreciated every day.", // Jan 31
////                "Happy February! A new month means new possibilities.", // Feb 1
////                "Stay strong, stay positive, and the day will reward you.", // Feb 2
////                "Your kindness will inspire others today.", // Feb 3
////                "May today be filled with laughter and good memories.", // Feb 4
////                "Believe in yourself, the universe is already behind you.", // Feb 5
////                "You are capable of achieving greatness today.", // Feb 6
////                "Allow yourself to be proud of how far you’ve come.", // Feb 7
////                "Let joy be your compass today.", // Feb 8
////                "You are a magnet for positive energy.", // Feb 9
////                "Let your confidence shine as brightly as the sun today.", // Feb 10
////                "Embrace the present, for it is a gift.", // Feb 11
////                "Your courage and persistence will pay off.", // Feb 12
////                "Find something to be thankful for today.", // Feb 13
////                "Valentine’s Day is near, love is in the air!", // Feb 14
////                "Surround yourself with positivity and watch your spirit soar.", // Feb 15
////                "Remember that you are stronger than you think.", // Feb 16
////                "Take time today to enjoy the little moments.", // Feb 17
////                "Your smile is the best way to brighten today.", // Feb 18
////                "May today be filled with hope and new opportunities.", // Feb 19
////                "You are a gift to those around you.", // Feb 20
////                "Take a deep breath, relax, and enjoy today.", // Feb 21
////                "Life is too short not to laugh a little today.", // Feb 22
////                "On our anniversary, I feel lucky to share every moment with you.", // Feb 23 (Your Anniversary)
////                "Keep your heart open to the beauty of today.", // Feb 24
////                "Today is the perfect day to be your best self.", // Feb 25
////                "May your efforts today lead to great rewards.", // Feb 26
////                "Celebrate your progress, no matter how small.", // Feb 27
////                "March is almost here, time for new beginnings.", // Feb 28
////                "Leap year or not, make the most of today.", // Feb 29 (Leap Year Special)
////                "Happy March! Embrace the new energy this month brings.", // Mar 1
////                "Take time to appreciate the journey, not just the destination.", // Mar 2
////                "Your positive energy will inspire others today.", // Mar 3
////                "Celebrate every little victory, they add up.", // Mar 4
////                "Embrace today with an open mind and heart.", // Mar 5
////                "Find joy in doing something kind for someone else.", // Mar 6
////                "Let today be filled with laughter and light.", // Mar 7
////                "International Women’s Day! Wish you more and more beautiful, successful and healthy. Love you!", // Mar 8 (International Women’s Day)
////                "Your hard work today will bring you closer to your dreams.", // Mar 9
////                "Enjoy today for what it is—a beautiful opportunity.", // Mar 10
////                "May you find peace in the little moments today.", // Mar 11
////                "Keep pushing forward, your goals are within reach.", // Mar 12
////                "Surround yourself with positivity, and watch your spirit soar.", // Mar 13
////                "Today is a blank canvas, paint it with happiness.", // Mar 14
////                "Smile more today, it’s the best gift you can give.", // Mar 15
////                "Cherish the simple pleasures in life today.", // Mar 16
////                "Let your kindness be the sunshine on a cloudy day.", // Mar 17
////                "Today is yours for the taking, make it count.", // Mar 18
////                "You are loved more than you know.", // Mar 19
////                "A small step today can lead to big things tomorrow.", // Mar 20
////                "The world is brighter because you are in it.", // Mar 21
////                "Spring is near, let your soul bloom.", // Mar 22
////                "Anniversaries remind me how lucky I am to have you.", // Mar 23 (Your Anniversary)
////                "Let today be a day of gratitude for all the good things in life.", // Mar 24
////                "You are capable of amazing things, take a step toward them today.", // Mar 25
////                "Spread kindness today and watch it come back to you tenfold.", // Mar 26
////                "Embrace today’s challenges, they are shaping you into something great.", // Mar 27
////                "Happiness is a choice, and today I choose to be happy.", // Mar 28
////                "May your heart be filled with peace and joy today.", // Mar 29
////                "Reflect on how far you’ve come, and be proud.", // Mar 30
////                "The journey is as important as the destination, enjoy the ride.", // Mar 31
////                "April is near, a fresh new month full of possibilities awaits.", // Apr 1
////                "Happy April! Let this month be a new beginning filled with hope.", // Apr 2
////                "May today bring you one step closer to your dreams.", // Apr 3
////                "Find joy in the little things, they make life beautiful.", // Apr 4
////                "Your smile can change someone’s day today, so share it generously.", // Apr 5
////                "Take a moment to breathe and appreciate the beauty around you.", // Apr 6
////                "You are stronger than you think, believe in yourself today.", // Apr 7
////                "Kindness is free, sprinkle it everywhere today.", // Apr 8
////                "Don’t forget to take care of yourself today, you deserve it.", // Apr 9
////                "Let your creativity flow, today is full of endless possibilities.", // Apr 10
////                "Surround yourself with positive people and watch your spirit soar.", // Apr 11
////                "Your efforts today will shape your tomorrow.", // Apr 12
////                "Gratitude turns what we have into enough, be thankful today.", // Apr 13
////                "May today be the day you achieve something great.", // Apr 14
////                "Life is what you make it, make today amazing.", // Apr 15
////                "Celebrate the good in your life and let it fuel your happiness.", // Apr 16
////                "Every day is a new opportunity to grow and improve.", // Apr 17
////                "Your positivity is contagious, spread it everywhere you go.", // Apr 18
////                "The best is yet to come, trust the process.", // Apr 19
////                "May your day be filled with moments of pure joy and laughter.", // Apr 20
////                "You are a beacon of light, keep shining brightly today.", // Apr 21
////                "Find peace in the present moment, it’s all we truly have.", // Apr 22
////                "Another anniversary, another beautiful reminder of our journey together.", // Apr 23 (Your Anniversary)
////                "Let today be a celebration of how far you’ve come.", // Apr 24
////                "The world is a better place with you in it.", // Apr 25
////                "Take a step toward your dreams today, no matter how small.", // Apr 26
////                "May today be filled with positivity, joy, and love.", // Apr 27
////                "Cherish the moments that make you smile, they are precious.", // Apr 28
////                "You are capable of achieving anything you set your mind to.", // Apr 29
////                "Reflect on the beauty of life and be thankful today.", // Apr 30
////                "Happy May! A fresh new month brings new opportunities.", // May 1
////                "May your day be filled with happiness, laughter, and peace.", // May 2
////                "Today is a new day, full of possibilities waiting to unfold.", // May 3
////                "You are stronger than you realize, keep pushing forward.", // May 4
////                "Let your heart be light and your spirit bright today.", // May 5
////                "Gratitude is the key to unlocking happiness, be thankful today.", // May 6
////                "Your kindness today will make the world a little brighter.", // May 7
////                "Find joy in the small moments, they are what make life sweet.", // May 8
////                "The best days are yet to come, keep moving forward with hope.", // May 9
////                "You are a source of light, keep shining and spreading positivity.", // May 10
////                "Believe in yourself and all that you are capable of.", // May 11
////                "Take a moment today to appreciate how far you’ve come.", // May 12
////                "May today be the start of something beautiful.", // May 13
////                "Every day is a gift, unwrapped with gratitude and joy.", // May 14
////                "You are enough just as you are, remember that today.", // May 15
////                "Let today be a day of growth and self-discovery.", // May 16
////                "Take time to relax and enjoy the simple pleasures today.", // May 17
////                "Your hard work will pay off, trust the process.", // May 18
////                "Happiness is a journey, not a destination. Enjoy the ride today.", // May 19
////                "You have the power to make today amazing.", // May 20
////                "Let go of worries and embrace the joy of the present moment.", // May 21
////                "You are capable of achieving great things, believe in yourself.", // May 22
////                "Another anniversary, another beautiful chapter in our story.", // May 23 (Your Anniversary)
////                "May today bring you peace, joy, and new opportunities.", // May 24
////                "You are a light in this world, keep shining bright.", // May 25
////                "Celebrate today as another step towards your dreams.", // May 26
////                "Let gratitude fill your heart and bring you joy.", // May 27
////                "You are stronger than any challenge you face today.", // May 28
////                "Happiness comes from within, choose joy today.", // May 29
////                "Every day is a chance to grow and learn something new.", // May 30
////                "As May ends, reflect on the beauty of this month.", // May 31
////                "Wish my Em bé has a wonderful Children's Day!", // Jun 1
////                "Let the warmth of June fill your heart with happiness.", // Jun 2
////                "You have the strength to overcome anything today.", // Jun 3
////                "A day filled with laughter is a day well spent.", // Jun 4
////                "Success is not final, failure is not fatal. Keep going.", // Jun 5
////                "Embrace today’s challenges with a positive mindset.", // Jun 6
////                "Your kindness will change someone’s world today.", // Jun 7
////                "May today be filled with moments of pure joy.", // Jun 8
////                "Take a moment to enjoy the little things in life today.", // Jun 9
////                "Your efforts today are paving the way for a brighter future.", // Jun 10
////                "Spread love and joy wherever you go today.", // Jun 11
////                "Be proud of how far you’ve come, and keep moving forward.", // Jun 12
////                "Every new day is a chance to create something beautiful.", // Jun 13
////                "Your positive energy is contagious, share it with the world.", // Jun 14
////                "Believe in yourself, you are capable of achieving great things.", // Jun 15
////                "Take a moment to reflect on all the good things in your life today.", // Jun 16
////                "May today be filled with laughter, love, and light.", // Jun 17
////                "You are the author of your story, make today a great chapter.", // Jun 18
////                "Kindness is the most beautiful form of strength, share it today.", // Jun 19
////                "May today be a day of peace, positivity, and progress.", // Jun 20
////                "The best days are ahead, keep moving forward.", // Jun 21
////                "Your heart knows the way, trust it today.", // Jun 22
////                "Our love grows stronger with each anniversary we celebrate.", // Jun 23 (Your Anniversary)
////                "Embrace the beauty of today, it’s a gift.", // Jun 24
////                "Your joy today will inspire others to find their own.", // Jun 25
////                "Take time to appreciate the journey you’re on.", // Jun 26
////                "Believe in the magic of new beginnings.", // Jun 27
////                "Let your light shine bright today and always.", // Jun 28
////                "Gratitude turns what we have into enough, be thankful today.", // Jun 29
////                "End June with a heart full of gratitude and hope.", // Jun 30
////                "Happy July! Let this month be filled with joy and possibilities.", // Jul 1
////                "Let July bring warmth, growth, and new beginnings.", // Jul 2
////                "You have the power to make today incredible.", // Jul 3
////                "Find beauty in the simple moments of life today.", // Jul 4
////                "Celebrate the small victories, they add up to great achievements.", // Jul 5
////                "Your resilience is your greatest strength, keep going.", // Jul 6
////                "May today be a day of peace, laughter, and love.", // Jul 7
////                "Be kind to yourself, you deserve it.", // Jul 8
////                "Every step you take brings you closer to your dreams.", // Jul 9
////                "Your positive energy is uplifting, share it with the world.", // Jul 10
////                "May today be the start of something wonderful.", // Jul 11
////                "Find joy in today’s journey, it’s part of your beautiful story.", // Jul 12
////                "Your efforts are planting the seeds for future success.", // Jul 13
////                "You are a source of light and love, keep shining.", // Jul 14
////                "Gratitude opens the door to abundance, be thankful today.", // Jul 15
////                "Believe in the endless possibilities that today holds.", // Jul 16
////                "Let today be filled with moments of happiness and laughter.", // Jul 17
////                "Your journey is unique, embrace it and move forward with joy.", // Jul 18
////                "Celebrate the beauty of life and all its moments today.", // Jul 19
////                "You are capable of more than you can imagine.", // Jul 20
////                "Happiness is found in the present, choose to be happy today.", // Jul 21
////                "Your smile can brighten someone’s day, share it freely.", // Jul 22
////                "Another anniversary, another reason to celebrate our love.", // Jul 23 (Your Anniversary)
////                "Let today be a day of reflection and gratitude.", // Jul 24
////                "You are capable of achieving great things, don’t stop now.", // Jul 25
////                "May today be filled with moments of peace and joy.", // Jul 26
////                "Take time to enjoy the simple pleasures in life.", // Jul 27
////                "Your resilience will carry you through today’s challenges.", // Jul 28
////                "Kindness is the most powerful force in the world, spread it today.", // Jul 29
////                "Celebrate the beauty of life and all its moments today.", // Jul 30
////                "End July with gratitude for all that you have and all that is to come.", // Jul 31
////                "Happy August! Let this month bring new beginnings and joy.", // Aug 1
////                "May August be a month of growth, learning, and happiness.", // Aug 2
////                "Embrace today’s possibilities with an open heart.", // Aug 3
////                "You have the power to make today amazing.", // Aug 4
////                "Take a moment to appreciate all the good in your life today.", // Aug 5
////                "Let your heart be filled with peace and positivity today.", // Aug 6
////                "You are stronger than any challenge that comes your way.", // Aug 7
////                "Your kindness will make the world a little brighter today.", // Aug 8
////                "Happiness is a choice, and today I choose to be happy.", // Aug 9
////                "Let your creativity flow, today is full of endless possibilities.", // Aug 10
////                "Spread love and joy wherever you go today.", // Aug 11
////                "May today bring you closer to your dreams and aspirations.", // Aug 12
////                "Find joy in today’s journey, it’s all part of your beautiful story.", // Aug 13
////                "Gratitude turns what we have into enough, be thankful today.", // Aug 14
////                "Celebrate the little things today, they make life sweeter.", // Aug 15
////                "Your efforts today are shaping a bright future ahead.", // Aug 16
////                "Take a deep breath, and know that everything will work out.", // Aug 17
////                "Today is a new opportunity to chase your dreams.", // Aug 18
////                "Let kindness be your compass, guiding you through the day.", // Aug 19
////                "You are capable of achieving greatness, believe in yourself.", // Aug 20
////                "May today be filled with peace, love, and laughter.", // Aug 21
////                "Embrace every challenge as a chance to grow.", // Aug 22
////                "Our love is the greatest adventure. Happy anniversary!", // Aug 23 (Your Anniversary)
////                "You are the light in someone’s life, keep shining.", // Aug 24
////                "Celebrate today as another step towards your dreams.", // Aug 25
////                "Every day brings new opportunities to grow and learn.", // Aug 26
////                "May your day be filled with positivity and joy.", // Aug 27
////                "Your strength lies in your kindness and compassion.", // Aug 28
////                "Take time to appreciate the simple things in life today.", // Aug 29
////                "May August be a month of growth, learning, and happiness.", // Aug 30
////                "End August with gratitude for the journey so far.", // Aug 31
////                "Embrace the start of September with an open heart.", // Sep 1
////                "May this new month bring you peace and fulfillment.", // Sep 2
////                "Smile at the beauty of life, and it will smile back at you.", // Sep 3
////                "Every day is a gift, unwrap it with gratitude.", // Sep 4
////                "Your energy can brighten someone's world today.", // Sep 5
////                "Chase your goals with determination and courage.", // Sep 6
////                "Happiness blooms where gratitude grows.", // Sep 7
////                "May today be filled with new possibilities.", // Sep 8
////                "You are stronger than you think. Keep going!", // Sep 9
////                "Celebrate small wins, for they lead to greater victories.", // Sep 10
////                "Kindness is free. Spread it everywhere you go.", // Sep 11
////                "Let today be a reminder of how far you've come.", // Sep 12
////                "Find joy in the journey, not just the destination.", // Sep 13
////                "Life is about balance. Take time for yourself today.", // Sep 14
////                "Your perseverance will take you places you never dreamed of.", // Sep 15
////                "Let your light shine bright and inspire others.", // Sep 16
////                "Gratitude turns what we have into enough.", // Sep 17
////                "Your potential is limitless, believe in yourself.", // Sep 18
////                "Make today count by doing something kind.", // Sep 19
////                "My birthday!! Glad that I can enjoy my birthday with you.", // Sep 20
////                "Embrace the changes that life brings.", // Sep 21
////                "Let go of what no longer serves you and make room for joy.", // Sep 22
////                "Another month of love with you, happy 23rd!", // Sep 23 (Your Anniversary)
////                "Every day is a chance to start fresh and do great things.", // Sep 24
////                "Fill your heart with love, and it will overflow.", // Sep 25
////                "Be fearless in the pursuit of what sets your soul on fire.", // Sep 26
////                "May today bring you new opportunities to shine.", // Sep 27
////                "Take a moment to reflect on all you've accomplished.", // Sep 28
////                "Let today be the day you believe in your power.", // Sep 29
////                "End this month with gratitude and love.", // Sep 30
////                "Welcome October with a heart full of possibilities.", // Oct 1
////                "The best is yet to come, stay hopeful.", // Oct 2
////                "Every moment is a new beginning.", // Oct 3
////                "Let go of worries, embrace peace.", // Oct 4
////                "Your kindness is a ripple that spreads far and wide.", // Oct 5
////                "Fill today with love, laughter, and adventure.", // Oct 6
////                "Celebrate your progress, no matter how small.", // Oct 7
////                "The only limit is the one you set yourself.", // Oct 8
////                "Choose happiness today, and watch it grow.", // Oct 9
////                "Believe in the magic of new beginnings.", // Oct 10
////                "Take a moment to breathe, you've got this.", // Oct 11
////                "Let positivity flow through every part of your day.", // Oct 12
////                "Remember, you are enough just as you are.", // Oct 13
////                "Today is a chance to do something extraordinary.", // Oct 14
////                "Your resilience is inspiring, keep pushing forward.", // Oct 15
////                "Be kind to yourself, you're doing your best.", // Oct 16
////                "Celebrate the little victories in life today.", // Oct 17
////                "You have the power to create the life you want.", // Oct 18
////                "Spread love and watch it come back to you.", // Oct 19
////                "Happy Vietnamese Women's Day! Wishing you endless beauty, strength, and success in everything you do. Thank you for all that you’ve done and all you will continue to do. Today is your day—enjoy it to the fullest!", // Oct 20
////                "Focus on the good, and the good will grow.", // Oct 21
////                "You are capable of amazing things.", // Oct 22
////                "Happy 23rd to us! Another beautiful milestone.", // Oct 23 (Your Anniversary)
////                "Take time to enjoy the present moment.", // Oct 24
////                "Surround yourself with positive energy today.", // Oct 25
////                "Happy Birthday, Eiuuu! On your special day, I want to remind you how incredibly amazing you are. Every moment with you is a treasure, and I am so grateful for all the joy and love you bring into my life. Here's to celebrating you today and always. I love you more than words can express. May this year be full of happiness, growth, and endless beautiful memories. Happy Birthday!", // Oct 26 (Her Birthday)",
////                "Trust the process, everything is unfolding perfectly.", // Oct 27
////                "Let today be the start of something new.", // Oct 28
////                "You are a source of light and hope for others.", // Oct 29
////                "Embrace the beauty of today.", // Oct 30
////                "End October with a heart full of joy.", // Oct 31
////                "A new month, new opportunities. Welcome November!", // Nov 1
////                "May November bring you peace, love, and joy.", // Nov 2
////                "Take time today to reflect on all the things you're grateful for.", // Nov 3
////                "Believe in yourself, and the world will believe in you too.", // Nov 4
////                "Let your inner light guide you through this day.", // Nov 5
////                "Fill your day with positivity, and let it lift your spirit.", // Nov 6
////                "You are capable of achieving great things. Keep going!", // Nov 7
////                "Life is a journey, and every step is an important part of it.", // Nov 8
////                "Your smile has the power to brighten someone else's day.", // Nov 9
////                "Live today with purpose and passion.", // Nov 10
////                "Keep moving forward, even if the path seems unclear.", // Nov 11
////                "You have the strength to overcome any challenge.", // Nov 12
////                "May your heart be filled with love and gratitude today.", // Nov 13
////                "Take time today to focus on what truly matters.", // Nov 14
////                "Let go of negativity, and embrace the good in life.", // Nov 15
////                "Your kindness can change the world around you.", // Nov 16
////                "Celebrate your achievements, no matter how small.", // Nov 17
////                "Every day is a new chance to grow and improve.", // Nov 18
////                "Find peace in the simple joys of life today.", // Nov 19
////                "Let your dreams inspire you to take action today.", // Nov 20
////                "Focus on the present moment, and make it count.", // Nov 21
////                "Let go of fear and embrace love and courage.", // Nov 22
////                "Happy 23rd! Another beautiful milestone in our journey.", // Nov 23 (Your Anniversary)
////                "Gratitude turns what we have into enough.", // Nov 24
////                "You are strong, capable, and worthy of great things.", // Nov 25
////                "Take a deep breath and enjoy the beauty around you.", // Nov 26
////                "Celebrate your progress and keep pushing forward.", // Nov 27
////                "Fill your heart with love and kindness today.", // Nov 28
////                "You are more resilient than you think.", // Nov 29
////                "End this month with a heart full of hope and gratitude.", // Nov 30
////                "Welcome December with joy and anticipation.", // Dec 1
////                "Let love and kindness guide your actions today.", // Dec 2
////                "The best way to spread joy is to live with a grateful heart.", // Dec 3
////                "Focus on what makes you happy, and let it grow.", // Dec 4
////                "Believe in the magic of the season and in yourself.", // Dec 5
////                "Take time to reflect on all that you've accomplished this year.", // Dec 6
////                "Your positivity can make the world a better place.", // Dec 7
////                "Embrace the beauty and joy of this moment.", // Dec 8
////                "Every step you take is bringing you closer to your dreams.", // Dec 9
////                "Fill today with gratitude, and your heart will be light.", // Dec 10
////                "May your day be filled with peace, love, and joy.", // Dec 11
////                "Focus on the good, and watch it grow.", // Dec 12
////                "You are capable of doing amazing things. Keep going!", // Dec 13
////                "Let today be a day of love, laughter, and joy.", // Dec 14
////                "Take time to appreciate the people in your life today.", // Dec 15
////                "You are stronger than any challenge you face.", // Dec 16
////                "Believe in yourself, and the world will believe in you too.", // Dec 17
////                "Spread love and kindness wherever you go today.", // Dec 18
////                "Let your actions today reflect the person you want to be.", // Dec 19
////                "Gratitude makes everything better. Focus on it today.", // Dec 20
////                "This is a season of joy. Let your heart be light.", // Dec 21
////                "Happy 23rd! Another month to celebrate our beautiful journey.", // Dec 23 (Your Anniversary)
////                "Let love be your guide today.", // Dec 24
////                "Merry Christmas! May your day be filled with love and laughter.", // Dec 25 (Christmas)
////                "Take time to reflect on the year and be proud of all you've done.", // Dec 26
////                "Let the joy of the season fill your heart today.", // Dec 27
////                "You have the power to create a wonderful day.", // Dec 28
////                "Fill today with laughter and love.", // Dec 29
////                "Celebrate the end of the year with gratitude and hope.", // Dec 30
////                "Happy New Year's Eve! Here's to a bright and beautiful new year ahead.", // Dec 31 (New Year's Eve)
////            };
////            for (int i = 0; i < lines.length; i++) {
////                Wishes wishes = new Wishes(i + 1, lines[i]);
////                wishesDAO.add(wishes);
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static void main(String[] args) {
        UpdateDatabase database = new UpdateDatabase();
        database.initData();
    }

    void initData() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            ImagesDAO imagesDAO = new ImagesDAOImp(session);
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/img/photo11.jpg"));
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/img/photo22.jpg"));
            ImageIcon us = new ImageIcon(getClass().getResource("/img/us2.jpg"));
            ImageIcon aiu = new ImageIcon(getClass().getResource("/img/aiu.jpg"));

            ImagesDAO imagesDAO1 = new ImagesDAOImp(session);
            Images images = new Images(Functional.convertIconToByteArray(icon1), Functional.convertIconToByteArray(icon2), Functional.convertIconToByteArray(us), Functional.convertIconToByteArray(aiu), true);
            imagesDAO1.add(images);

        } catch (Exception e) {
        }
    }
}
