const chatStore = {
    namespaced: true,
    state: {
        message: null,
        messages:[],
        targetId: null,
    },
    getters: {
        getMessage: function(state){
            return state.message;
        },
        getTargetId: function(state){
            return state.targetId;
        },
    },
    mutations: {
        SET_MESSAGE: (state, message)=>{
            state.message = message;
        },
        SET_TARGETID: (state, targetId)=>{
            state.targetId = targetId;
        }
    },
    actions: {
        set_message({commit},message){
            commit("SET_MESSAGE",message);
        },
        set_targetId({commit},targetId){
            commit("SET_TARGETID",targetId);
        }
    },
};

export default chatStore;
