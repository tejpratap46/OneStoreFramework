package com.brainstrom.onestoreframework.cloud;

public class URLs {
    public static final String HOST_NAME = "ONE STORE";
    public static final String API_ENDPOINT = "http://www.nfcstore.vv.si/";
    public static final String API_KEY = "tejpratap";

    public static final int SearchProductById = 0;
    public static final int SearchProductByName = 1;
    public static final int SearchProductByPrice = 2;
    public static final int SearchProductByDescription = 3;
    public static final int SearchProductByCategory = 4;
    public static final int SearchProductByBrand = 5;
    public static final int SearchProductByQuantity = 6;
    public static final int SearchProductByYear = 7;
    public static final int SearchProductByMonth = 8;

    public static final int SearchCustomerByName = 50;
    public static final int SearchCustomerByUsername = 51;
    public static final int SearchCustomerByemail = 52;
    public static final int SearchCustomerBybankid = 53;

    /*
    * Methods To Generate API Call URL with Parameters.
    */

    /*
    * Query The Database.
    */

    public String queryURL(String SQLQuery) {
        return API_ENDPOINT + "query.php?apikey=" + API_KEY + "&query=" + SQLQuery;
    }

    /*
    * Market APIs
    */

    /*
    * Get All Categories
    */

    public String marketCategoriesURL() {
        return API_ENDPOINT + "market/market.categories.php?apikey=" + API_KEY;
    }

    /*
    * Get All Brands In A Specific Categories
    */

    public String marketCategoriesBrandsURL(String category) {
        return API_ENDPOINT + "market/market.categorybrands.categories.php?apikey=" + API_KEY + "&category=" + category;
    }

    /*
    * Delete A Item From Market
    */

    public String marketDeleteItemURL(String ItemId) {
        return API_ENDPOINT + "market/market.categorybrands.php?apikey=" + API_KEY + "&id=" + ItemId;
    }

    /*
    * Delete All Items From Market
    */

    public String marketDeleteAllItemsURL() {
        return API_ENDPOINT + "market/market.deleteall.php?apikey=" + API_KEY;
    }

    /*
    * Delete Items From Market In Descending Order Of Their Arrival
    */

    public String marketFreshItemsURL(int page) {
        return API_ENDPOINT + "market/market.fresh.php?apikey=" + API_KEY + "&page=" + page;
    }

    /*
    * Delete Items From Market In Descending Order Of Their Total Sales
    */

    public String marketTopItemsURL(int page) {
        return API_ENDPOINT + "market/market.top.php?apikey=" + API_KEY + "&page=" + page;
    }

    /*
    * Get Products Without Any Order By
    */

    public String marketGetItemsURL(int page) {
        return API_ENDPOINT + "market/market.showall.php?apikey=" + API_KEY + "&page=" + page;
    }

    /*
    * Insert Item Into Market
    */

    public String marketInsertItemURL(String itemId, String itemName, String itemPrice, String itemDiscreption, String itemSpecification, String itemCategory, String itemBrand, String quantity, String imageUrl, String itemLocation, String tags) {
        return API_ENDPOINT + "market/market.insert.php?apikey=" + API_KEY + "&itemid=" + itemId + "&itemname=" + itemName + "&itemprice=" + itemPrice + "&itemdiscreption=" + itemDiscreption + "&itemspecification=" + itemSpecification + "&itemcategory=" + itemCategory + "&itembrand=" + itemBrand + "&quantity=" + quantity + "&imageurl=" + imageUrl + "&itemlocation=" + itemLocation + "&tags=" + tags;
    }

    /*
    * Quick Glance Info Of A Product
    */

    public String marketQuickShowItemURL(String itemId) {
        return API_ENDPOINT + "market/market.quickshow.php?apikey=" + API_KEY + "&itemid=" + itemId;
    }

    /*
    * Search A Product
    */

    public String marketSearchItemByURL(int Type, String q, int page) {
        String ret = "";
        switch (Type) {
            case SearchProductById:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemid=" + q + "&page=" + page;
                break;
            case SearchProductByName:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemname=" + q + "&page=" + page;
                break;
            case SearchProductByPrice:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemprice=" + q + "&page=" + page;
                break;
            case SearchProductByDescription:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemdiscreption=" + q + "&page=" + page;
                break;
            case SearchProductByCategory:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemcategory=" + q + "&page=" + page;
                break;
            case SearchProductByBrand:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itembrand=" + q + "&page=" + page;
                break;
            case SearchProductByQuantity:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&quantity=" + q + "&page=" + page;
                break;
            case SearchProductByYear:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&year=" + q + "&page=" + page;
                break;
            case SearchProductByMonth:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&month=" + q + "&page=" + page;
                break;
            default:
                ret = API_ENDPOINT + "market/market.search.php?apikey=" + API_KEY + "&itemdiscreption=" + q + "&page=" + page;
        }
        return ret;
    }

    /*
    * Search A Product
    */

    public String marketSearchItemURL(String q) {
        return API_ENDPOINT + "market/market.search1.php?apikey=" + API_KEY + "&q=" + q;
    }

    /*
    * Get Product Info
    */

    public String marketShowItemURL(String itemId) {
        return API_ENDPOINT + "market/market.search1.php?apikey=" + API_KEY + "&itemid=" + itemId;
    }

    /*
    * Update Product Info
    * Leave The Parameter as a blank string
    * You Cannot Update ItemId And It Is Used As A Index For item to update
    */

    public String marketUpdateItemURL(String itemId, String itemName, String itemPrice, String itemDiscreption, String itemSpecification, String itemCategory, String itemBrand, String quantity, String imageUrl, String itemLocation, String tags) {
        return API_ENDPOINT + "market/market.update.php?apikey=" + API_KEY + "&itemid=" + itemId + "&itemname=" + itemName + "&itemprice=" + itemPrice + "&itemdiscreption=" + itemDiscreption + "&itemspecification=" + itemSpecification + "&itemcategory=" + itemCategory + "&itembrand=" + itemBrand + "&quantity=" + quantity + "&imageurl=" + imageUrl + "&itemlocation=" + itemLocation + "&tags=" + tags;
    }

     /*
     * Bank Operations
     */

    /*
    * Delete All Accounts From Table
    */

    public String bankDeleteAllURL() {
        return API_ENDPOINT + "bank/bank.deleteall.php?apikey=" + API_KEY;
    }

    /*
    * get Info Of Single Account
    */

    public String bankGetInfoURL(String bankId) {
        return API_ENDPOINT + "bank/bank.show.php?apikey=" + API_KEY + "&bankid=" + bankId;
    }

    /*
    * get Info Of All Accounts
    */

    public String bankGetAllInfoURL() {
        return API_ENDPOINT + "bank/bank.showall.php?apikey=" + API_KEY;
    }

    /*
    * Transfer Amount Between Accounts
    */

    public String bankTransferURL(String fromBankId, String toBankid, String balance, String listId) {
        return API_ENDPOINT + "bank/bank.transfer.php?apikey=" + API_KEY + "&frombankid=" + fromBankId + "&tobankid=" + toBankid + "&balance=" + balance + "&listid=" + listId;
    }

    /*
    * Update Amount Of Account
    */

    public String bankUpdateAmountURL(String bankId, String balance) {
        return API_ENDPOINT + "bank/bank.update.php?apikey=" + API_KEY + "&bankid=" + bankId + "&balance=" + balance;
    }

     /*
     * Cart Operations
     */

    /*
    * Add To Cart
    */

    public String cartAddURL(String username, String items) {
        return API_ENDPOINT + "cart/cart.add.php?apikey=" + API_KEY + "&username=" + username + "&items=" + items;
    }

    /*
    * Remove From Cart
    */

    public String cartRemoveURL(String username, int pos) {
        return API_ENDPOINT + "cart/cart.remove.php?apikey=" + API_KEY + "&username=" + username + "&pos=" + pos;
    }

    /*
    * Save Cart As A List
    */

    public String cartSaveURL(String username, int pos) {
        return API_ENDPOINT + "cart/cart.save.php?apikey=" + API_KEY + "&username=" + username;
    }

    /*
     * Coupon Operations
     */

    /*
    * Apply Coupon To A list
    */

    public String couponAddURL(String code, String itemids, String percentage) {
        return API_ENDPOINT + "coupon/coupon.add.php?apikey=" + API_KEY + "&code=" + code + "&itemids=" + itemids + "&percentage=" + percentage;
    }

    /*
    * Apply Coupon To A list
    */

    public String couponCheckURL(String coupon, String listId) {
        return API_ENDPOINT + "coupon/coupon.check.php?apikey=" + API_KEY + "&coupon=" + coupon + "&listid=" + listId;
    }

    /*
     * Customer Operations
     */

    /*
    * Get Current List Of A Customer
    */

    public String customerCurrentListURL(String username) {
        return API_ENDPOINT + "customer/customer.currentlist.php?apikey=" + API_KEY + "&username=" + username;
    }

    /*
    * Delete A Customer
    */

    public String customerDeleteURL(String username) {
        return API_ENDPOINT + "customer/customer.delete.php?apikey=" + API_KEY + "&id=" + username;
    }

    /*
    * Delete All Customer
    */

    public String customerDeleteAllURL() {
        return API_ENDPOINT + "customer/customer.deleteall.php?apikey=" + API_KEY;
    }

    /*
    * Login A Customer
    */

    public String customerLoginURL(String username, String password) {
        return API_ENDPOINT + "customer/customer.login.php?apikey=" + API_KEY + "&username=" + username + "&password=" + password;
    }

    /*
    * Recommended Products For A Customer
    */

    public String customerRecommendedURL(String username) {
        return API_ENDPOINT + "customer/customer.recommend.php?apikey=" + API_KEY + "&username=" + username;
    }

    /*
    * Register A New Customer
    */

    public String customerRegisterURL(String name, String username, String email, String password, String bankid, String gcmid) {
        return API_ENDPOINT + "customer/customer.register.php?apikey=" + API_KEY + "&name=" + name + "&username=" + username + "&email=" + email + "&password=" + password + "&bankid=" + bankid + "&gcmid=" + gcmid;
    }

    /*
    * Search A Customer By name, username, email etc
    */

    public String customerSearchByURL(int type, String q) {
        String ret = "";
        switch (type) {
            case SearchCustomerByName:
                ret = API_ENDPOINT + "customer/customer.search.php?apikey=" + API_KEY + "&name=" + q;
                break;
            case SearchCustomerByUsername:
                ret = API_ENDPOINT + "customer/customer.search.php?apikey=" + API_KEY + "&username=" + q;
                break;
            case SearchCustomerByemail:
                ret = API_ENDPOINT + "customer/customer.search.php?apikey=" + API_KEY + "&email=" + q;
                break;
            case SearchCustomerBybankid:
                ret = API_ENDPOINT + "customer/customer.search.php?apikey=" + API_KEY + "&bankid=" + q;
                break;
            default:
                ret = API_ENDPOINT + "customer/customer.search.php?apikey=" + API_KEY + "&name=" + q;
        }
        return ret;
    }

    /*
    * Search A Customer
    */

    public String customerSearchURL(String q) {
        return API_ENDPOINT + "customer/customer.recommend.php?apikey=" + API_KEY + "&q=" + q;
    }

    /*
    * Search A Customer
    */

    public String customerGetCustomersURL() {
        return API_ENDPOINT + "customer/customer.showall.php?apikey=" + API_KEY;
    }

    /*
    * Update Customer Info
    * You cannot Update Username Or BankId
    * Leave The Parameter Blank If You Don't Want To Update It
    */

    public String customerUpdateURL(String name, String username, String email, String password, String bankid, String gcmid) {
        return API_ENDPOINT + "customer/customer.update.php?apikey=" + API_KEY + "&name=" + name + "&username=" + username + "&email=" + email + "&password=" + password + "&bankid=" + bankid + "&gcmid=" + gcmid;
    }


    /*
    * Featured/Coupon Products Customer
    */

    /*
    * Get Items Under A Coupon
    */

    public String couponGetCouponURL(String code) {
        return API_ENDPOINT + "featured/featured.show.php?apikey=" + API_KEY + "&code=" + code;
    }

    /*
    * Get Items Under A Coupon
    */

    public String couponAddCouponURL(String code,String imageurl,String description) {
        return API_ENDPOINT + "featured/featured.add.php?apikey=" + API_KEY + "&code=" + code + "&imageurl=" + imageurl + "&description=" + description;
    }

    /*
    * Delete A Coupon
    */

    public String couponDeleteURL(String code) {
        return API_ENDPOINT + "featured/featured.delete.php?apikey=" + API_KEY + "&code=" + code;
    }

    /*
    * Delete A Coupon
    */

    public String couponDeleteAllURL() {
        return API_ENDPOINT + "featured/featured.deleteall.php?apikey=" + API_KEY;
    }

    /*
    * Get All Coupons
    */

    public String couponGetAllURL() {
        return API_ENDPOINT + "featured/featured.showall.php?apikey=" + API_KEY;
    }

    /*
    * Lists Of Customer
    */

    /*
    * Check If All Items Are Present In Market
    */

    public String listCheckURL(String listid) {
        return API_ENDPOINT + "lists/lists.check.php?apikey=" + API_KEY + "&listid=" + listid;
    }

    /*
    * Delete A List
    */

    public String listDeleteURL(String listid) {
        return API_ENDPOINT + "lists/lists.delete.php?apikey=" + API_KEY + "&listid=" + listid;
    }

    /*
    * Delete All Lists
    */

    public String listDeleteURL() {
        return API_ENDPOINT + "lists/lists.deleteall.php?apikey=" + API_KEY;
    }

    /*
    * Add A New List
    * items should be in format of :
    * <id>1</id><name>Huawei Honor Holly (Black/White)</name><quantity>1</quantity><cost>6999</cost>
    */

    public String listInsertURL(String username, String items) {
        return API_ENDPOINT + "lists/lists.insert.php?apikey=" + API_KEY + "&username=" + username + "&items=" + items;
    }

    /*
    * Get All Lists By A User
    */

    public String listByUserURL(String username) {
        return API_ENDPOINT + "lists/lists.listsby.php?apikey=" + API_KEY + "&username=" + username;
    }

    /*
    * Set List To Newest Of User
    */

    public String listSetCurrentURL(String username, String listid) {
        return API_ENDPOINT + "lists/lists.setcurrent.php?apikey=" + API_KEY + "&username=" + username + "&listid=" + listid;
    }

    /*
    * Share A List To Another User
    */

    public String listShareURL(String toUsername, String listid) {
        return API_ENDPOINT + "lists/lists.share.php?apikey=" + API_KEY + "&customerid=" + toUsername + "&listid=" + listid;
    }

    /*
    * Get A Single List By A User
    */

    public String listShowURL(String listId) {
        return API_ENDPOINT + "lists/lists.show.php?apikey=" + API_KEY + "&listid=" + listId;
    }

    /*
    * Get All Lists
    */

    public String listShowAllURL() {
        return API_ENDPOINT + "lists/lists.showall.php?apikey=" + API_KEY;
    }

    /*
    * Update Market When A List Is Sold
    */

    public String listSoldURL(String listId) {
        return API_ENDPOINT + "lists/lists.sold.php?apikey=" + API_KEY + "&listid=" + listId;
    }

    /*
    * This section uses loyalty features of the framework
    */

    /*
     * get Loyalty Stats Of user
     */

    public String loyaltyGetUrl(String username){
        return API_ENDPOINT + "loyalty/loyalty.get.php?apikey=" + API_KEY + "&username=" + username;
    }

    /*
     * Use Loyalty Points Loyalty Of user
     */

    public String loyaltyUsePointsUrl(String username, String PointsToUse){
        return API_ENDPOINT + "loyalty/loyalty.usepoints.php?apikey=" + API_KEY + "&username=" + username + "&points=" + PointsToUse;
    }

    /*
    * Control Push Notifications To User
    */

    /*
    * Update Market When A List Is Sold
    */

    public String notificationSendURL(String gcmId,String title,String message) {
        return API_ENDPOINT + "notification/notification.send.php?apikey=" + API_KEY + "&gcmId=" + gcmId + "&title=" + title + "&message=" + message;
    }

    /*
    * Orientation Stuff
    */

    /*
    * get Map For A Floor Or Segment
    * @param floor : maps are separated from floor
    */

    public String orientationShowMapURL(String floor) {
        return API_ENDPOINT + "orientation/orientation.showmap.php?apikey=" + API_KEY + "&floor=" + floor;
    }

    /*
    * get Path For A List
    */

    public String orientationGetPathURL(String listId) {
        return API_ENDPOINT + "orientation/orientation.tsp.php?apikey=" + API_KEY + "&listid=" + listId;
    }

    /*
    * Payment Methods And Related Stuff
    */

    /*
    * Send A Payment
    * @param : fromId : Bank Id Of Customer Paying
    * toId : Bank Id Of Receiver
    * listId : List For Which Payment Is Being Processed
    */

    public String paymentSendURL(String fromid, String toid, String balance, String listid) {
        return API_ENDPOINT + "payment/payment.send.php?apikey=" + API_KEY + "&fromid=" + fromid + "&toid=" + toid + "&balance=" + balance + "&listid=" + listid;
    }

    /*
    * Receive A Payment
    * @param : Id : Payment Id
    * Bank Id : Bank Id Of Receiver
    */

    public String paymentReceiveURL(String id, String bankId) {
        return API_ENDPOINT + "payment/payment.send.php?apikey=" + API_KEY + "&id=" + id + "&bankid=" + bankId;
    }

    /*
    * Receive A Cash Payment, dose not deduct main balance
    * @param : bankId : From Bank Id
    * balance : Amount To Transfer
    */

    public String paymentReceiveCashURL(String balance, String bankId) {
        return API_ENDPOINT + "payment/payment.receivecash.php?apikey=" + API_KEY + "&balance=" + balance + "&bankid=" + bankId;
    }

    /*
    * Receive A Cash Payment, dose not require user account
    * @param : balance : Amount To Transfer
    */

    public String paymentReceiveCashFromUnregisteredUserURL(String balance) {
        return API_ENDPOINT + "payment/payment.receivecashfromunregistereduser.php?apikey=" + API_KEY + "&balance=" + balance;
    }

    /*
    * Get Payments Made Today
    */

    public String paymentGetTodaysURL() {
        return API_ENDPOINT + "payment/payment.gettodays.php?apikey=" + API_KEY;
    }

    /*
    * All Information About Payments Completed
    */

    /*
    * Get All payments Completed From Stone Age
    */

    public String paymentCompletedGetAllUrl(){
        return API_ENDPOINT + "payment_completed/payment_completed.getall.php?apikey=" + API_KEY;
    }

    /*
    * Get Payments Completed Today
    */

    public String paymentCompletedGetTodaysUrl(){
        return API_ENDPOINT + "payment_completed/payment_completed.gettodays.php?apikey=" + API_KEY;
    }
}
