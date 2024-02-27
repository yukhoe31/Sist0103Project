<template>
  <div id="app">
    <FirstApp></FirstApp>
    <SecondApp></SecondApp>
    <ThirdApp></ThirdApp>
    <FourthApp></FourthApp>
    <FifthApp></FifthApp>
  </div>
</template>

<script>
//필요한 App만 주석 없이 사용하기.
//밑에 export default의 components에서도 해당 App 적어주기
//import FirstApp from './components/FirstApp.vue';
//import SecondApp from './components/SecondApp.vue';
//import ThirdApp from './components/ThirdApp.vue';
import FourthApp from './components/FourthApp.vue';
//import FifthApp from './components/FifthApp.vue';

export default {
    setup() {
        return {};
    },
    components: { FourthApp}
  }
</script>

<style lang="scss" scoped>

</style>