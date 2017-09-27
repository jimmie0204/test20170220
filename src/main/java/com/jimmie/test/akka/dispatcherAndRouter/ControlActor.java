package com.jimmie.test.akka.dispatcherAndRouter;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;
import akka.routing.RoundRobinPool;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Router;
import akka.routing.RouterActor;

public class ControlActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof StartCommand) {

//            List<ActorRef> actors = createActors(((StartCommand) message).getActorCount());

            /*这里使用了JDK1.8中的StreamAPI*/
//            actors.stream().parallel().forEach(actorRef -> actorRef.tell("Insert", ActorRef.noSender()));
            
            //使用router路由消息
            
//         Router router = new Router(new RoundRobinRoutingLogic());
//
//            for (ActorRef actor : actors) {
//                router = router.addRoutee(actor);
//                //需要注意,需要接收addRoutee的返回
//            }
//
//            router.route("Insert",ActorRef.noSender());
//            router.route("Insert",ActorRef.noSender());
            
        	//外置路由
//            Props props = Props.create(WriterActor.class).withRouter(new RoundRobinPool(((StartCommand) message).getActorCount())).withDispatcher("writer-dispatcher");
//            ActorRef routerActorRef = getContext().actorOf(props);
//            for(int i=0;i<20;i++){
//            	routerActorRef.tell("Insert",self());
//            }
            
            //配置文件设置路由用deployment方式
            Props routerProps = Props.create(WriterActor.class).withRouter(new FromConfig()).withDispatcher("writer-dispatcher");
            ActorRef router = getContext().system().actorOf(routerProps, "router");
//            
            //用直接配置方式(不好使)
//            Props routerProps = Props.create(WriterActor.class).withRouter(new FromConfig(null, null, "routerJimmie")).withDispatcher("writer-dispatcher");
//            ActorRef router = getContext().system().actorOf(routerProps);
            
            for(int i=0;i<20;i++){
            	router.tell("Insert",self());
            }
            
        }
    }

    private List<ActorRef> createActors(int actorCount) {
        Props props = Props.create(WriterActor.class).withDispatcher("writer-dispatcher");
        
        List<ActorRef> actors = new ArrayList<>(actorCount);
        for (int i = 0; i < actorCount; i++) {
            actors.add(getContext().actorOf(props,"writer_"+ i));
        }
        return actors;
    }
}