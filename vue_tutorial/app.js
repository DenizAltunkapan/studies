const app = Vue.createApp({
    data(){
        return {
            title: "Hello, Vue :D",
            counter:0,
            visibility: false
        }
    },
    methods: {
        changeTitle(){
            this.title = this.inputValue
        },
        changeVisibility(){
            this.visibility = !this.visibility
        }
    }
})

app.mount('#app')