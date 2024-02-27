<template>
    <div>
        <h1 class="alert alert-info">FourthApp 입니다.</h1>
    </div>
</template>

<script>

export default {
    setup () {

        const fruitArray=['apple','banana','orange'];
        const infoArray=[{id:0,user:'영수'},{id:1,user:'영식'},{id:2,user:'영철'},{id:3,user:'광수'}]

        
        return {
            fruitArray,
            infoArray
        }
    }
}
</script>

<style lang="scss" scoped>

</style>