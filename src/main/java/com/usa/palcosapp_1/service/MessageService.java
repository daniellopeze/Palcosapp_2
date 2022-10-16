package com.usa.palcosapp_1.service;

import com.usa.palcosapp_1.model.Message;
import com.usa.palcosapp_1.repository.MessageRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepossitory messageRepossitory;

    public List<Message> getAll(){
        return messageRepossitory.getAll();
    }
    public Optional<Message> getById(Integer id){
        return messageRepossitory.getById(id);
    }
    public Message save (Message message){
        if (message.getIdMessage()==null){
            return  messageRepossitory.save(message);
        }else{
            Optional<Message> optional=messageRepossitory.getById(message.getIdMessage());
            if (optional.isEmpty()){
                return messageRepossitory.save(message);
            }else{
                return message;
            }
        }
    }
    public  Message update (Message message){
        if (message.getIdMessage()!=null){
            Optional<Message> optional=messageRepossitory.getById(message.getIdMessage());
            if (!optional.isEmpty()){
                if (message.getMessageText()!=null){
                    optional.get().setMessageText(message.getMessageText());
                    optional.get().setClient(message.getClient());
                    optional.get().setBox(message.getBox());
                }
                messageRepossitory.save(optional.get());
                return optional.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete (Integer id){
        Boolean aBoolean=getById(id).map(message -> {
            messageRepossitory.delete(message);
            return true;
        }).orElse( false);
        return aBoolean;
    }
}


