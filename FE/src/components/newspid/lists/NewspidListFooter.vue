<template>
    <span>
        &nbsp;
        <a style="text-decoration: none;">
            <!-- 좋아요 안 눌렀다면 -->
            <!-- <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                    d="M8.926 3.408a.503.503 0 0 0-.03-.067 2.653 2.653 0 0 0-.285-.435 4.27 4.27 0 0 0-.805-.781c-.667-.497-1.571-.866-2.68-.731-1.57.19-2.557 1.037-3.157 2.05-.625 1.057-.859 2.349-.791 3.384.067 1.022.175 1.864.685 2.938.535 1.123 1.549 2.577 3.57 4.66 1.897 1.956 3.228 3.232 4.08 4.006a.72.72 0 0 0 .487.202c.16 0 .33-.06.487-.202l-.29-.319.29.319c.852-.774 2.183-2.05 4.08-4.005 2.021-2.084 3.035-3.537 3.57-4.66.51-1.075.619-1.917.685-2.939.068-1.032-.168-2.324-.796-3.382-.602-1.016-1.59-1.862-3.153-2.052-.968-.119-1.877.235-2.605.755a4.86 4.86 0 0 0-.875.799c-.101.119-.172.216-.219.287l-.017.026a.5.5 0 0 0-.083.147c-.194.532-.634.833-1.074.833-.44 0-.88-.301-1.074-.833Zm2.356.618.253-.426-.253.426Zm-1.752-.98a.5.5 0 0 0 .94 0c.098-.269.444-.78 1.02-1.289C12.35 1 13.58.367 14.932.532c1.731.21 2.896 1.168 3.623 2.392.735 1.24 1.012 2.744.932 3.975-.071 1.085-.194 2.078-.782 3.314-.595 1.25-1.68 2.78-3.727 4.89-1.904 1.963-3.247 3.25-4.114 4.038-.528.479-1.2.479-1.728 0-.867-.787-2.21-2.075-4.114-4.038-2.047-2.11-3.132-3.64-3.727-4.89C.707 8.977.585 7.984.514 6.9c-.08-1.232.193-2.737.926-3.975C2.164 1.7 3.329.743 5.068.532 6.555.35 7.74.974 8.539 1.71c.554.51.885 1.043.991 1.335Z"
                    fill="#fff" stroke="#000" stroke-linejoin="round" />
            </svg> -->
            <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                    d="M5.007.035C7.822-.307 9.656 1.928 10 2.875c.344-.947 2.424-3.153 4.993-2.84 3.816.466 5.165 4.26 4.993 6.897-.146 2.224-.517 4.26-4.649 8.519-1.91 1.968-3.26 3.264-4.137 4.06-.719.652-1.68.652-2.4 0-.877-.796-2.227-2.092-4.137-4.06C.531 11.19.16 9.156.015 6.93-.158 4.296 1.175.502 5.007.036Z"
                    fill="#F0355B" />
            </svg>
        </a>
        &nbsp;
        <a style="text-decoration: none;">
            <svg width="23" height="23" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M2.453 7.581c-1.809.606-1.874 3.14-.098 3.838l6.47 2.541c.106.042.19.125.231.231l2.542 6.471c.697 1.776 3.232 1.71 3.837-.098l5.229-15.627c.535-1.598-.987-3.12-2.585-2.584L2.453 7.58Zm.499 2.317a.408.408 0 0 1 .02-.767l14.39-4.816-8.072 8.072-6.338-2.489Zm7.57 3.568c.02.042.038.085.055.128l2.541 6.47c.14.356.647.343.768-.019l5-14.943-8.364 8.364Z"
                    fill="#000" />
            </svg>
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a style="text-decoration: none;">
            <svg width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M5.143 4.286v13.85l5.382-3.768a2.571 2.571 0 0 1 2.95 0l5.382 3.768V4.286H5.143ZM19.714 2.57c.474 0 .857.384.857.858v16.353c0 .694-.78 1.1-1.348.703l-6.731-4.712a.857.857 0 0 0-.984 0l-6.73 4.712a.857.857 0 0 1-1.35-.703V3.43c0-.474.384-.858.858-.858h15.428Z"
                    fill="#000" />
            </svg>
        </a>
    </span>
    <b-row>
        <b-col
            style="padding-right: 5px; text-align: left; font-weight: bold; font-size: 14px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; margin-left: 10px;">
            좋아요 {{ favor }}개</b-col>
    </b-row>
    <b-row>
        <b-col style="color:gray; font-size: 10px; margin-left: 10px;">
            {{ setTimes }}
        </b-col>
    </b-row>
</template>

<script>
export default {
    props: {
        pidNo: Number,          // 뉴스피드 번호
        creativetimes: Object,    // 작성 날짜
        favor: Number,          // 좋아요 개수
    },
    computed: {
        setTimes() {
            const now = new Date();
            const year = this.creativetimes.year;
            const month = this.creativetimes.month;
            const date = this.creativetimes.date;
            const hour = this.creativetimes.hour;
            const min = this.creativetimes.min;

            console.log("year : " + year);
            if (now.getFullYear() - year > 0)
                return (now.getFullYear() - year) + "년 전";
            else if (now.getMonth() - month > 0) // year = 0 이므로
                return (now.getMonth() - month) + "개월 전";
            else if (now.getDate() - date > 0)
                return (now.getDate() - date) + "일 전";
            else if (now.getHours() - hour > 0)
                return (now.getHours() - hour) + "시간 전";
            else if (now.getMinutes() - min > 0)
                return (now.getMinutes() - min) + "분 전";
            else return "방금 전";
        }
    }
}
</script>

<style>
</style>